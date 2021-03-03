<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="glossy">
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          @click="leftDrawerOpen = !leftDrawerOpen"
          aria-label="Menu"
          icon="menu"
        />

        <q-toolbar-title> Bitingbit News App </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-page-container>
      <div id="q-app">
        <div class="q-pa-md">
          <q-tabs
            v-model="tab"
            dense
            align="justify"
            class="bg-primary text-white shadow-2"
            :breakpoint="0"
          >
            <q-route-tab name="news" label="News" to="/news"> </q-route-tab>
            <q-route-tab name="user" label="User" to="/user"></q-route-tab>
          </q-tabs>
          <q-tab-panels v-model="tab" animated>
            <q-tab-panel name="news">
              <router-view />
            </q-tab-panel>
            <q-tab-panel name="user">
              <router-view />
            </q-tab-panel>
          </q-tab-panels>
        </div>
      </div>
    </q-page-container>
  </q-layout>
</template>

<script>
import { ref } from 'vue';

export default {
  components: {},

  data() {
    return {
      tab: 'News',
    };
  },

  setup() {
    return {
      leftDrawerOpen: ref(false),
    };
  },
};
</script>
