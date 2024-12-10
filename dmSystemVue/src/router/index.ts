import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'logOn',
      component: () => import('../views/logOn/logOn.vue')
    },
    {
      path: '/home',
      name: 'home',
      component: HomeView,
      redirect: '/home/main',
      children: [
        {
          path: 'main',
          name: 'main',
          component: () => import('../views/main/main.vue')
        },
        {
          path: 'warranty',
          name: 'warranty',
          component: () => import('../views/warranty/warrantyView.vue')
        },
        {
          path: 'testView',
          name: 'testView',
          component: () => import('../views/testView.vue')
        },
      ]
    },
    {
      path: '/regiSter',
      name: 'regiSter',
      component: () => import('../views/regiSter/regiSter.vue')
    },
  ]
})

export default router
