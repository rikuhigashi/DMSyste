import api from "@/api/axios";
import type { AxiosResponse } from "axios";
import type { Result } from "@/api/axios";
import router from "@/router";

interface loginData {
    useraccount: string
    userpassword: string
}


export async function login(params: loginData) {
    try {
        const res: AxiosResponse<Result> = await api.post('/user/login', params)
        console.log(params);

        if (res.data.code === 200) {
            console.log("登录成功");
            location.href = "http://localhost:5173/home";
        } else {
            console.log("错误,登录失败");

        }
    } catch (error) {
        console.log("输入为空，登录失败", error);
    }
}