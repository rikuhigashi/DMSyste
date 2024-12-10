import axios from 'axios';

export interface Result {
    code: number;  // 状态码
    msg: string;   // 信息
    total?: number; // 可选的总记录数
    data?: any;     // 可选的数据字段
}


const api = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 5000
})


export default api;