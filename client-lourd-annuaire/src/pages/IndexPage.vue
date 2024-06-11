<template>
  <q-page class="row items-center justify-evenly">
      <q-input
        class="col-4"
        v-model="rechercheNom"
        label="Rechercher par nom"
      ></q-input>
      <q-select
        class="col-2"
        v-model="selectedSite"
        :options="siteOptions"
        emit-value
        map-options
        label="Sélectionner un site"
        option-value="id"
        option-label="label"
      />
      <q-select
        class="col-2"
        v-model="selectedService"
        :options="serviceOptions"
        emit-value
        map-options
        label="Sélectionner un service"
        option-value="id"
        option-label="label"
      />
  <div v-if="ajaxtrue && data">
    <div v-if="!boolAdmin">
    <q-table 
    :rows="data"
    :columns="columnsUser"
    /></div>
    <div v-if="boolAdmin">
    <q-table
    :rows="data"
    :columns="columnsAdmin"
    >
    <template v-slot:body-cell-action="props">
          <q-td :props="props">
            <q-btn
              color="grey"
              label="Supprimer"
              @click="deleteRow(props.row)"
            />
          </q-td>
        </template>
    </q-table>
    </div>
    <div class="row items-center justify-evenly">
      <q-btn label="accès administrateur" color="primary" class="q-mt-md" @click="isAdmin"/>
    </div>
  </div>
  </q-page>
</template>

<script setup lang="ts">
import { QTableColumn } from 'quasar';
import { ref, onMounted, watch } from 'vue';
import { api } from 'boot/axios';

defineOptions({
  name: 'IndexPage'
});

const data = ref(null);
const ajaxtrue = ref(false);
const idSite = ref(null);
const idService = ref(null);
const rechercheNom = ref(null);
const selectedService = ref(null);
const selectedSite = ref(null);
const boolAdmin = ref(false);

onMounted(() => {
  ajaxCall();
});

function isAdmin() {
  boolAdmin.value = !boolAdmin.value;
}

function deleteRow(row) {
  api.delete('/employe/' + row.id).then(() => {
    ajaxCall();
  });
}

async function ajaxCall() {
  try {
    const response = await api.get('/global', {
      params: {
        nom: rechercheNom.value,
        service: idService.value,
        site: idSite.value,
      },
    });
    data.value = response.data;
    ajaxtrue.value = true;
  } catch (error) {
    console.log('Erreur :', error);
  }
}

const columnsUser: QTableColumn[] = [

  {
    name: 'nom',
    required: true,
    label: 'Nom',
    align: 'left',
    field: (row) => row.nom,
    sortable: true
  },
  {
    name: 'prenom',
    align: 'left',
    label: 'Prénom',
    field: (row) => row.prenom,
    sortable: true
  },
  {
    name: 'telephoneFixe',
    align: 'left',
    label: 'Téléphone Fixe',
    field: (row) => row.telephoneFixe,
    sortable: true
  },
  {
    name: 'telephonePortable',
    align: 'left',
    label: 'Téléphone Portable',
    field: (row) => row.telephonePortable,
    sortable: true
  },
  {
    name: 'ville',
    align: 'left',
    label: 'Ville',
    field: (row) => row.ville,
    sortable: true
  },
  {
    name: 'service',
    align: 'left',
    label: 'Service',
    field: (row) => row.service,
    sortable: true
  },
];

const columnsAdmin: QTableColumn[] = [

  {
    name: 'id',
    required: true,
    label: 'Id',
    align: 'left',
    field: (row) => row.id,
    sortable: true
  },
  {
    name: 'nom',
    required: true,
    label: 'Nom',
    align: 'left',
    field: (row) => row.nom,
    sortable: true
  },
  {
    name: 'prenom',
    align: 'left',
    label: 'Prénom',
    field: (row) => row.prenom,
    sortable: true
  },
  {
    name: 'telephoneFixe',
    align: 'left',
    label: 'Téléphone Fixe',
    field: (row) => row.telephoneFixe,
    sortable: true
  },
  {
    name: 'telephonePortable',
    align: 'left',
    label: 'Téléphone Portable',
    field: (row) => row.telephonePortable,
    sortable: true
  },
  {
    name: 'ville',
    align: 'left',
    label: 'Ville',
    field: (row) => row.ville,
    sortable: true
  },
  {
    name: 'service',
    align: 'left',
    label: 'Service',
    field: (row) => row.service,
    sortable: true
  },
  {
    name: 'action',
    align: 'center',
    label: 'Action',
    field: 'action',
  },
];

const serviceOptions = [
  { id: null, label: 'Tous' },
  { id: 1, label: 'Comptabilité' },
  { id: 2, label: 'Production' },
  { id: 3, label: 'Accueil' },
  { id: 4, label: 'Informatique' },
  { id: 5, label: 'Commercial' },
  { id: 6, label: 'Transport' },
  { id: 7, label: 'Juridique' },
];

const siteOptions = [
  { id: null, label: 'Tous' },
  { id: 1, label: 'Paris' },
  { id: 2, label: 'Nantes' },
  { id: 3, label: 'Toulouse' },
  { id: 4, label: 'Nice' },
  { id: 5, label: 'Lille' },
];

watch(rechercheNom, () => {
  ajaxtrue.value = false;
  ajaxCall();
});

watch(selectedSite, () => {
  idSite.value = selectedSite.value === null ? null : selectedSite.value;
  ajaxtrue.value = false;
  ajaxCall();
});

watch(selectedService, () => {
  idService.value =
    selectedService.value === null ? null : selectedService.value;
  ajaxtrue.value = false;
  ajaxCall();
});

</script>
