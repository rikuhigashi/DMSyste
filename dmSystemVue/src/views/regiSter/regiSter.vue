<template>
  <div class="flex items-center justify-center w-full h-screen " >
    <div class="flex w-1/2 bg-white rounded-md">
      <div class="flex-1">
       <img src="../../assets/image/img/登录注册.png" class="w-full h-full" alt=""/>
      </div>
      <div class="flex items-center justify-center flex-1 align-items-center hover:bg-black/50">
        <el-form :model="form" class="w-4/5">
          <div class="mt-1 mb-3 font-serif text-xl font-bold text-center">欢迎来到注册界面</div>
          <el-form-item part="username">
              <el-input  class="size-9" type="text" v-model="form.username" placeholder="请输入用户名" prefix-icon="User" />
          </el-form-item>
          <el-form-item part="password">
              <el-input  class="size-9" type="password" v-model="form.password"  placeholder="请输入密码" prefix-icon="Lock" show-password/>
          </el-form-item>
          <el-form-item part="passwordTo">
              <el-input  class="size-9" type="password" v-model="form.passwordTo"  placeholder="请再次输入密码" prefix-icon="Lock" show-password/>
          </el-form-item>
          <el-form-item class="flex items-center justify-center text-center">
            <button class="w-full btn glass" @click="regiSter()" type="button">注 册</button>
          </el-form-item>
          <div class="flex items-center mb-1 text-center">
            <div class="flex justify-start">
              有账号？<span class="cursor-pointer text-emerald-500 hover:text-green-950" onclick="window.location.href='http://localhost:5173/'">立即登录</span>
            </div>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>


<script lang="ts" setup>
import {regin} from "@/views/regiSter/regiSter";
import { ElMessage } from 'element-plus';
import { ref } from 'vue'

const form=ref({
  username:'',
  password:'',
  passwordTo: ''
})

const regiSter = async () => {
   if(!form.value.username||!form.value.password||!form.value.passwordTo){
      ElMessage({ type: 'error', message: '请输入完内容！' })
      return;
    }else  if(form.value.password!=form.value.passwordTo){
      ElMessage({ type: 'error', message: '两次密码输入不一致！' })
      return;
    }else if(form.value.password==form.value.passwordTo){
     await regin({
       useraccount:form.value.username,
       userpassword:form.value.password,
     })
    }else {
      ElMessage({ type: 'error' })
      return;
    }
}
// // const input = ref('')
// // // console.log(el);
// export default {
// name: 'regiSteer',
// data() {
//   return {
//     form: {
//       username: '',
//       password: '',
//       passwordTo: '',
//     },
//     username: '',
//     password: '',
//     passwordTo: '',
//   };
// },
// methods: {
//   // handleSubmit() {
//   //   console.log(this.username, this.password);
//   // },
//   // getCode(code:string){
//   //     // console.log(code);
//   //     this.code = code;
//   // },
//   regiSter(){
//     // console.log(this.form.code)
//     if(!this.form.username||!this.form.password||!this.form.passwordTo){
//       ElMessage({ type: 'error', message: '请输入完内容！' })
//       return;
//     }else  if(this.form.password!=this.form.passwordTo){
//       ElMessage({ type: 'error', message: '两次密码输入不一致！' })
//       return;
//     }else if(this.form.password==this.form.passwordTo){
//       //zq
//     }else {
//       ElMessage({ type: 'error' })
//       return;
//     }
//   }
// },
// };
</script>

