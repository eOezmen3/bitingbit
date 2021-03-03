import { createApp } from 'vue';

import { Quasar } from 'quasar';
import router from './router/router';
import App from './App.vue';
import quasarUserOptions from './quasar-user-options';

createApp(App)
  .use(Quasar, quasarUserOptions)
  .use(router)
  .mount('#app');
