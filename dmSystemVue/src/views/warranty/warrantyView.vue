<script lang="ts" setup>
import { onMounted } from 'vue';
import { Search } from '@element-plus/icons-vue'
import {
    searchData,
    logoPost,
    resetParam,
    add,
    tableData,
    currentPage,
    pageSize,
    size,
    total,
    background,
    disabled,
    handleSizeChange,
    handleCurrentChange,
    loadData,
    centerDialogVisible,
    form,
    saveData,
    rules,
    formRef,
    mod,
    del
} from './warranty';

onMounted(() => {
    loadData()
})

</script>


<template>
    <div>
        <!-- 按钮、搜索框 -->
        <div style="margin-bottom: 5px;">
            <el-input v-model="searchData.title" placeholder="请输入标题" :suffix-icon="Search" style="width: 200px;"
                @keyup.enter="logoPost" />
            <el-input v-model="searchData.studentnumber" placeholder="请输入学生学号" :suffix-icon="Search"
                style="width: 240px;margin-left: 10px;" @keyup.enter="logoPost">
            </el-input>
            <el-input v-model="searchData.worknumber" placeholder="请输入工号" :suffix-icon="Search"
                style="width: 240px;margin-left: 10px;" @keyup.enter="logoPost">
            </el-input>

            <el-button type="primary" style="margin-left: 5px;" @click="logoPost">查询</el-button>
            <el-button type="success" @click="resetParam">重置</el-button>
            <el-button type="primary" @click="add">新增</el-button>
        </div>


        <!-- 主体 -->
        <el-table :data="tableData" :header-cell-style="{ background: '#9b999b', color: '#ffffff' }" border
            highlight-current-row>
            <el-table-column prop="id" label="保修单号" width="60" />
            <el-table-column prop="title" label="保修标题" width="130" />
            <el-table-column prop="name" label="修理物品" width="100" />
            <el-table-column prop="starttime" label="开始时间" width="170" />
            <el-table-column prop="endtime" label="结束时间" width="170" />
            <el-table-column prop="studentname" label="申请人" width="80" />
            <el-table-column prop="studentnumber" label="申请人学号" width="110" />
            <el-table-column prop="workname" label="处理人" width="80" />
            <el-table-column prop="worknumber" label="工作人员工号" width="120" />

            <el-table-column prop="remark" label="备注" width="120" />


            <el-table-column prop="operate" label="操作">
                <template #default="scope">

                    <el-button type="primary" size="small" @click="mod(scope.row)">
                        编辑
                    </el-button>

                    <el-popconfirm title="确定删除吗?" @confirm="del(scope.row.id)">
                        <template #reference>
                            <el-button type="danger" size="small">
                                删除
                            </el-button>
                        </template>
                    </el-popconfirm>

                </template>
            </el-table-column>
        </el-table>


        <!-- 点击新增出现窗口 -->
        <el-dialog v-model="centerDialogVisible" title="新增表单" width="700" align-center>

            <!-- 内容 -->
            <el-form ref="formRef" :model="form" :rules="rules" label-width="80px" style="max-width: 700px;" center>
                <div class=" flex justify-center items-center">
                    <el-form-item label="保修单号" class=" w-9/12">
                        <el-input v-model="form.id" disabled />
                    </el-form-item>
                    <el-form-item label="物品名" prop="name" class=" w-9/12">
                        <el-input v-model="form.name" />
                    </el-form-item>
                </div>

                <el-form-item label="标题" prop="title" class=" w-9/12">
                    <el-input v-model="form.title" />
                </el-form-item>

                <div class=" flex justify-center items-center">
                    <el-form-item label="修理时间" class=" w-9/12">
                        <el-date-picker type="date" placeholder="Pick a date" v-model="form.starttime"
                            style="width: 100%" />
                    </el-form-item>
                    <el-form-item label="结束时间" class=" w-9/12">
                        <el-time-picker placeholder="Pick a time" v-model="form.endtime" style="width: 100%" />
                    </el-form-item>
                </div>

                <div class=" flex justify-center items-center">
                    <el-form-item label="学生学号" prop="studentnumber" class=" w-9/12">
                        <el-input v-model="form.studentnumber" />
                    </el-form-item>
                    <el-form-item label="学生姓名" prop="studentname" class=" w-9/12">
                        <el-input v-model="form.studentname" />
                    </el-form-item>
                </div>

                <div class=" flex justify-center items-center">
                    <el-form-item label="人员工号" prop="worknumber" class=" w-9/12">
                        <el-input v-model="form.worknumber" />
                    </el-form-item>
                    <el-form-item label="人员姓名" prop="workname" class=" w-9/12">
                        <el-input v-model="form.workname" />
                    </el-form-item>
                </div>

                <div>
                    <el-form-item label="故障原因" prop="remark">
                        <el-input v-model="form.remark" style="width: 400px" :autosize="{ minRows: 2, maxRows: 4 }"
                            type="textarea" placeholder="Please input" />
                    </el-form-item>
                </div>
            </el-form>
            <!-- 内容 -->

            <!-- 确认按钮 -->
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="centerDialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="saveData">
                        确定
                    </el-button>
                </div>
            </template>
        </el-dialog>


        <!-- 分页 -->
        <div class="demo-pagination-block">
            <el-pagination v-model:current-page="currentPage" v-model:page-size="pageSize" :page-sizes="[5, 10, 20, 50]"
                :size="size" :disabled="disabled" :background="background"
                layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
                @current-change="handleCurrentChange" />
        </div>
    </div>

</template>


<style scoped>
.avatar-uploader .avatar {
    width: 178px;
    height: 178px;
    display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
    border: 1px dashed var(--el-border-color);
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
    border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    text-align: center;
}
</style>