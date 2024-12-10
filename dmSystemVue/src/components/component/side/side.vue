<script lang="ts" setup>
import { House, ChatLineSquare } from '@element-plus/icons-vue'
import { userSidebarStore } from '@/stores/sidebar';


const sidebarStore = userSidebarStore();
</script>


<template>

  <el-menu default-active="2" class="h-full el-menu-vertical-demo" :collapse="sidebarStore.isCollapsed">

    <!-- logo -->
    <div class="container text-center logo" v-if="!sidebarStore.isCollapsed">
      宿舍管理系统
    </div>
    <div class="container text-center logo" v-else>
      宿舍
    </div>
    <!-- logo -->




    <router-link to="/home">
      <el-menu-item index="1">
        <el-icon>
          <House />
        </el-icon>
        <template #title>首页</template>
      </el-menu-item>
    </router-link>

    <el-sub-menu index="2">
      <template #title>
        <el-icon>
          <ChatLineSquare />
        </el-icon>
        <span>公告</span>
      </template>
      <el-menu-item-group>

        <router-link to="#">
          <el-menu-item index="2-1">公告1</el-menu-item>
        </router-link>

        <router-link to="test">
          <el-menu-item index="2-2">公告2</el-menu-item>
        </router-link>

      </el-menu-item-group>
    </el-sub-menu>


    <el-sub-menu index="3">
      <template #title>
        <el-icon>
          <ChatLineSquare />
        </el-icon>
        <span>信息管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="3-1">管理1</el-menu-item>

        <router-link to="testView">
          <el-menu-item index="3-2">管理2</el-menu-item>
        </router-link>

      </el-menu-item-group>
    </el-sub-menu>


    <el-sub-menu index="4">
      <template #title>
        <el-icon>
          <ChatLineSquare />
        </el-icon>
        <span>报修管理</span>
      </template>
      <el-menu-item-group>

        <router-link to="warranty">
          <el-menu-item index="4-1">报修</el-menu-item>
        </router-link>

      </el-menu-item-group>
    </el-sub-menu>


    <el-sub-menu index="5">
      <template #title>
        <el-icon>
          <ChatLineSquare />
        </el-icon>
        <span>评分管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="5-1">评分1</el-menu-item>
        <el-menu-item index="5-2">评分2</el-menu-item>
      </el-menu-item-group>
    </el-sub-menu>




  </el-menu>
</template>



<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>
