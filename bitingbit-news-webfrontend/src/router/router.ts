import { createWebHistory, createRouter } from 'vue-router';
import News from '@/components/News.vue';
import User from '@/components/User.vue';
import App from '../App.vue';

const history = createWebHistory();
const router = createRouter({
  history,
  routes: [
    {
      path: '/',
      component: App,
    },
    {
      path: '/news',
      component: News,
    },

    {
      path: '/user',
      component: User,
    },
  ],
});

export default router;
