<script lang="ts" setup>
import { Fold, Expand } from '@element-plus/icons-vue'
import { ref } from 'vue';
import { userSidebarStore } from '@/stores/sidebar';

// 图标点击切换
const isExpanded = ref(true);
const sidebarStore = userSidebarStore()

const changeFE = () => {
  isExpanded.value = !isExpanded.value
  sidebarStore.toggleSidebar();
}
// 图标点击切换


// 鼠标移入移出出现图标
const showIcon = ref(false)
const iconChange = () => {
  showIcon.value = true
}
const iconSel = () => {
  showIcon.value = false
}
// 鼠标移入移出出现图标


</script>


<template>

  <div class="navbar bg-base-100 " @mouseenter="iconChange" @mouseleave="iconSel">

    <div class="flex-1 mt-2 mr-3 text-right " >
      <el-icon :size="25" @click="changeFE">
        <component :is="isExpanded ? Expand : Fold" v-if="showIcon" />
      </el-icon>
    </div>


    <div class="flex-none gap-2">
      <div class="z-50 dropdown dropdown-end">
        <label tabindex="0" class="btn btn-ghost btn-circle avatar">
          <div class="w-10 rounded-full">
            <img src="../../../assets/image/userHead/用户.png" />
          </div>
        </label>
        <ul tabindex="0" class="p-2 shadow dropdown-content menu bg-base-100 rounded-box w-52">
          <li><a>个人中心</a></li>
          <li><a onclick="window.location.href='http://localhost:5173/'">退出登录</a></li>
        </ul>
      </div>
    </div>
  </div>
</template>
