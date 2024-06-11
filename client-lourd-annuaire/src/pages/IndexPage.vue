<template>
  <q-page class="row items-center justify-evenly">
  <div v-if="ajaxtrue && data">
    <q-table 
    :rows="data"
    :columns="columnsUser"
    />
    </div>
  </q-page>
</template>

<script setup lang="ts">
import { QTableColumn } from 'quasar';
import { ref, onMounted } from 'vue';
import { api } from 'boot/axios';

defineOptions({
  name: 'IndexPage'
});

const data = ref(null);
const ajaxtrue = ref(false);

onMounted(() => {
  ajaxCall();
});

async function ajaxCall() {
  try {
    const response = await api.get('/global', {
    });
    data.value = response.data;
    ajaxtrue.value = true;
  } catch (error) {
    console.log('Erreur :', error);
  }
}

const columnsUser: QTableColumn[] = [
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
];

</script>
