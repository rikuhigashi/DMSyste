<script lang="ts" setup>
import { ref } from 'vue';

const headData = [
    { data: '宿舍楼', number: 8 },
    { data: '宿舍数量', number: 160 },
    { data: '学生人数', number: 2200 },
    { data: '空床数量', number: 80 },
]

const midData = [
    { data: '代办中心' },
    { data: '宿舍行程' }
]

const missionCenter = [
    { data: '任务中心' }
]

const notificationCenter = [
    { data: '通知中心' }
]

</script>

<template>

    <!-- 顶部4个框 -->
    <div class=" flex flex-row space-x-4 h-28 ">
        <div class=" basis-1/4 flex justify-center items-center bg-lime-500 " v-for="(item, index) in headData"
            :key="index">
            {{ item.data }}
            {{ item.number }}
        </div>
    </div>
    <!-- 顶部4个框 -->


    <!-- 中间主体 -->
    <div class="flex mt-10 space-x-4 justify-center items-center ">

        <div class="w-full basis-4/5  text-center">

            <div class="flex flex-row space-x-10 w-3/5 h-56 mx-auto">
                <el-card class="w-full mt-5 flex justify-center items-cente" v-for="(item, index) in midData"
                    :key="index">
                    <p>{{ item.data }}</p>
                </el-card>
            </div>

            <div class=" flex flex-row space-x-8 w-3/5 h-56 mx-auto">
                <el-card class="w-full mx-30 mt-12 flex justify-center items-cente"
                    v-for="(item, index) in missionCenter" :key="index">
                    <p>{{ item.data }}</p>
                </el-card>
            </div>

        </div>

        <div class="flex h-full w-full basis-2/5 "
            v-for="(item, index) in notificationCenter" :key="index">
            <el-card class="w-full flex justify-center items-cente">
                {{ item.data }}
            </el-card>
        </div>

    </div>





    <!-- 中间主体 -->




</template>
