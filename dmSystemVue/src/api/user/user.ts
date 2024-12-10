import api from "@/api/axios"

export const getUserList = async () => {
    try {
        const res = await api.get('/user/list');
        return res.data;
    } catch (error) {
        throw error
    }
}