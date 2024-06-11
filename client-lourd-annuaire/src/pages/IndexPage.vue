<template>
  <q-page class="row items-center justify-evenly">
  <q-btn color="primary" label="Ajax" @click="ajaxCall"/>
  <div v-if="ajaxtrue && data">{{ data }}</div>
  </q-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { api } from 'boot/axios';

defineOptions({
  name: 'IndexPage'
});

const data = ref(null);
const ajaxtrue = ref(false);

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

</script>
