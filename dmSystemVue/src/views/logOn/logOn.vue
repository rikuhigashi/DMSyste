<template>
  <div class="flex items-center justify-center w-full h-screen ">
    <div class="flex w-1/2 bg-white rounded-md">
      <div class="flex-1">
        <img src="../../assets/image/img/登录注册.png" class="w-full h-full" alt="" />
      </div>
      <div class="flex items-center justify-center flex-1 align-items-center hover:bg-black/50">
        <el-form :model="form" class="w-4/5">
          <div class="mt-1 mb-5 font-serif text-xl font-bold text-center">欢迎来到登录界面</div>
          <el-form-item part="username">
            <el-input class="size-9" type="text" v-model="form.username" placeholder="请输入用户名" prefix-icon="User" />
          </el-form-item>
          <el-form-item part="password">
            <el-input class="size-9" type="password" v-model="form.password" placeholder="请输入密码" prefix-icon="Lock"
              show-password />
          </el-form-item>
          <el-form-item part="code">
            <div class="flex">
              <el-input class="flex-initial w-64 size-9" v-model="form.code" type="text" placeholder="请输入验证码"
                prefix-icon="Smoking" @keyup.enter="logOn()" />
              <div class="flex-initial ml-8 w-36 h-9">
                <VoidContent @getValue="getCode" />
              </div>
            </div>
          </el-form-item>
          <el-form-item class="flex items-center justify-center text-center">
            <button class="w-full btn glass" @click="logOn()" type="button">登 录</button>
          </el-form-item>
          <div class="flex items-center mb-1 text-center">
            <div class="flex justify-start flex-1">
              没账号？<span class="cursor-pointer text-emerald-500 hover:text-green-950"
                onclick="window.location.href='http://localhost:5173/regiSter'">立即注册</span>
            </div>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>


<script lang="ts" setup>
import VoidContent from "@/components/component/VoidContent/VoidContent.vue";
import { ElMessage } from 'element-plus';
import { login } from './log'
import { ref } from 'vue'


const form = ref({
  username: '',
  password: '',
  code: '',//输入的验证码
  VCcode: ''//组件的验证码
})

const logOn = async () => {
  console.log(form.value)
  if (!form.value.code) {
    ElMessage({ type: 'error', message: '验证码不能为空！' })
    return;
  } else if (form.value.code != form.value.VCcode) {
    ElMessage({ type: 'error', message: '验证码不正确！' })
    return;
  } else if (form.value.code == form.value.VCcode) {
    await login({
      useraccount: form.value.username,
      userpassword: form.value.password,
    })
  } else {
    ElMessage({ type: 'error' })
    return;
  }

}

const getCode = (code: string) => {
  form.value.VCcode = code;
  console.log(code)
}

</script>


<!-- <script lang="ts">
import VoidContent from "@/components/component/VoidContent/VoidContent.vue";
import {ElMessage} from 'element-plus';
import {login} from '@/api/logAndReg/log'
import { ref } from 'vue';

export default {
  name: 'logOn',
  components: {VoidContent},
  data() {
    return {
      VCcode: '',//组件的验证码
      form: {
        username: '',
        password: '',
        code: ''//输入的验证码
      },
      username: '',
      password: '',
    };
  },
  methods: {
    // handleSubmit() {
    //   console.log(this.username, this.password);
    // },
    getCode(code: string) {
      this.VCcode = code;
      // console.log(this.code);
    },
    logOn() {
      if (!this.form.code) {
        ElMessage({type: 'error', message: '验证码不能为空！'})
        return;
      } else if (this.form.code != this.VCcode) {
        ElMessage({type: 'error', message: '验证码不正确！'})
        return;
      } else if (this.form.code == this.VCcode) {
        login({
          useraccount:this.form.username,
          userpassword:this.form.password,
        })
      } else {
        ElMessage({type: 'error'})
        return;
      }

    }
  },
};
</script> -->
