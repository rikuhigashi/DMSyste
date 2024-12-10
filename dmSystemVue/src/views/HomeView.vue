<template>
  <el-container class="layout-container-demo">
    <el-aside :width="sidebarWidth">
      <sideVue />
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <headVue />
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>


</template>

<script lang="ts" setup>
import sideVue from '@/components/component/side/side.vue';
import headVue from '@/components/component/head/head.vue';
import { computed } from 'vue';
import { userSidebarStore } from '@/stores/sidebar';

const sidebarStore = userSidebarStore();
const sidebarWidth = computed(() => (sidebarStore.isCollapsed ? '64px' : '200px'));

</script>


<style>
.layout-container-demo {
  width: 100%;
  height: 100vh;
}

.el-aside {
  transition: width 0.6s;
}

.el-main {
  transition: width 0.6s;
  overflow: auto;
}
</style>
