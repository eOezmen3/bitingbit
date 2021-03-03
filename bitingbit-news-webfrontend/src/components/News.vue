<template>
  <div v-for="n in news" :key="n.id">
    <q-card>
      <h4>{{ n.headline }}</h4>
      <p>{{ n.content }}</p>
    </q-card>
  </div>
</template>

<style></style>

<script>
import axios from 'axios';
import { onMounted, ref } from 'vue';

export default {
  name: 'News',

  setup() {
    const news = ref({});
    const fetchNews = async () => {
      const axiosConfig = {
        headers: {
          'Content-Type': 'application/json;charset=UTF-8',
          'Access-Control-Allow-Origin': '*',
        },
      };
      const response = await axios.get(
        'http://localhost:8080/news-src1/',
        // eslint-disable-next-line comma-dangle
        axiosConfig
      );

      const response2 = await axios.get(
        'http://localhost:8080/news-src2/',
        // eslint-disable-next-line comma-dangle
        axiosConfig
      );
      news.value = response.data.concat(response2.data);
    };

    onMounted(() => {
      fetchNews();
    });

    return {
      news,
      fetchNews,
    };
  },
};
</script>
