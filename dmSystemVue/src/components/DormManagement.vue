<template>
  <div>
    <el-input placeholder="请输入宿舍号编号"></el-input>
    <el-button type="primary">图标、搜索</el-button>
    <el-button type="danger">图标、批量删除</el-button>
    <el-table :data="dormList" stripe>
      <el-table-column type="selection"></el-table-column>
      <el-table-column prop="id" label="宿舍编号"></el-table-column>
      <el-table-column prop="max" label="可容纳人数"></el-table-column>
      <el-table-column prop="bj" label="所属班级"></el-table-column>
      <el-table-column prop="mn" label="收费标准(年)"></el-table-column>
      <el-table-column  label="操作">
        <template #default="scope">
          <el-button type="text">编写</el-button>
          <el-button type="text">修改</el-button>
          <el-button type="text">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      layout="prev, pager, next"
      :total="total"
    ></el-pagination>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const dormList = ref([
  {id:'001', max:'6', bj:'1班', mn:'1000'},
  {id:'002', max:'6', bj:'2班', mn:'1000'},
  {id:'003', max:'6', bj:'3班', mn:'1000'}
])
const total = ref(24)
</script>