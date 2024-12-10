import api from "@/api/axios";
import type { AxiosResponse } from "axios";
import type { Result } from "@/api/axios";

interface regiSterData {
  useraccount: string
  userpassword: string
}


export async function regin(params: regiSterData) {
  try {
    const res: AxiosResponse<Result> = await api.post('/user/add', params)
    console.log(params);
    if (res.data.code === 200) {
      console.log("注册成功");
    } else {
      console.log(res.data.code)
      console.log("错误,注册失败");

    }
  } catch (error) {
    throw  error;
  }
}
