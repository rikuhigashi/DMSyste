import api from '@/api/axios';
import type { Result } from '@/api/axios';
import { ElMessage, type ComponentSize, type FormInstance, type FormRules } from 'element-plus';
import { nextTick, reactive, ref } from 'vue';

export const formRef = ref<FormInstance>()

// 查询
export const searchData = ref({
    title: '',
    studentnumber: null as number | null,
    worknumber: null as number | null
})

export const logoPost = () => {
    // console.log("这是查询输出结果:");
    loadData()
}

//重置
export const resetParam = () => {
    searchData.value.title = '',
        searchData.value.studentnumber = null,
        searchData.value.worknumber = null
    loadData()
}

//点击添加按钮
export const add = async () => {
    centerDialogVisible.value = true

    await nextTick()
    resetForm()
}


// 表格
export const tableData = ref<any>([])
export const loadData = async () => {

    searchData.value.studentnumber = searchData.value.studentnumber ? +searchData.value.studentnumber : null;
    searchData.value.worknumber = searchData.value.worknumber ? +searchData.value.worknumber : null;

    try {
        const res = await api.post<Result>('/warranty/listSearchAndPagination', {
            pageSize: pageSize.value,
            pageNum: currentPage.value,
            param: {
                ...searchData.value
            }
        })
        // console.log('API Response:', res.data.data);
        if (res.data.data && res.data.code === 200) {
            tableData.value = res.data.data
            total.value = res.data.total
        } else {
            console.error("列表数据加载失败!");
        }
    } catch (error) {
        console.error("请求失败!", error);
    }
}

// 修改
export const mod = async (row: any) => {
    // console.log("这是mod方法", row);

    await nextTick()
    centerDialogVisible.value = true

    form.id = row.id
    form.name = row.name
    form.title = row.title
    form.starttime = row.starttime
    form.endtime = row.endtime
    form.studentnumber = row.studentnumber
    form.studentname = row.studentname
    form.worknumber = row.worknumber
    form.workname = row.workname
    form.remark = row.remark
}


// 删除
export const del = async (id: any) => {
    // console.log("这是del方法", id);
    try {
        const res = await api.delete<Result>('/warranty/del?id=' + id)
        if (res.data.code === 200) {
            ElMessage({
                type: 'success',
                message: `删除成功`,
            })
            loadData()
        } else {
            ElMessage({
                type: 'warning',
                message: `删除失败`,
            })

        }
    } catch (error) {
        throw error
    }
}

// 表格

// 弹出窗口
export const form = reactive({
    id: '',
    name: '',
    title: '',
    image: '',
    starttime: null,
    endtime: null,
    studentnumber: '',
    studentname: '',
    worknumber: '',
    workname: '',
    remark: ''
})

// 点击新增后保存
export const saveData = async () => {
    formRef.value?.validate(async (valid) => {
        if (valid) {
            try {
                const res = await api.post<Result>('/warranty/saveOrUpdate', form)
                if (res.data.code === 200) {
                    ElMessage({
                        type: 'success',
                        message: `数据添加/修改成功`,
                    })
                    centerDialogVisible.value = false
                    loadData()
                } else {
                    ElMessage({
                        type: 'warning',
                        message: `数据添加失败`,
                    })
                }
            } catch (error) {
                throw error
            }

        } else {
            ElMessage({
                type: 'error',
                message: '请检查填写的内容',
            })
        }
    })
}

export const centerDialogVisible = ref(false)


// 重置表单
export const resetForm = () => {
    form.id = '';
    form.name = '';
    form.title = '';
    form.image = '';
    form.starttime = null;
    form.endtime = null;
    form.studentnumber = '';
    form.studentname = '';
    form.worknumber = '';
    form.workname = '';
    form.remark = '';
}

// 表单校验规则
export const rules = {
    name: [
        { required: true, message: '请输入物品名', trigger: 'blur' }
    ],
    title: [
        { required: true, message: '请输入标题', trigger: 'blur' }
    ],
    studentnumber: [
        { required: true, message: '请输入学生学号', trigger: 'blur' },
    ],
    studentname: [
        { required: true, message: '请输入学生姓名', trigger: 'blur' }
    ],
    worknumber: [
        { required: true, message: '请输入人员工号', trigger: 'blur' },
    ],
    workname: [
        { required: true, message: '请输入人员姓名', trigger: 'blur' }
    ],
    remark: [
        { required: true, message: '请输入故障原因', trigger: 'blur' }
    ]
};

// 弹出窗口


// 页脚
export const currentPage = ref(1)
export const pageSize = ref(10)
export const size = ref<ComponentSize>('default')
export const disabled = ref(false)
export const background = ref(false)
export const total = ref<any>(0)

export const handleSizeChange = (val: number) => {
    // console.log(`${val} items per page`)
    currentPage.value = 1
    pageSize.value = val
    loadData()
}
export const handleCurrentChange = (val: number) => {
    // console.log(`current page: ${val}`)
    currentPage.value = val
    loadData()
}
// 页脚




