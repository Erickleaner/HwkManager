import axios from "axios";

export const mockRequest = axios.create({
    baseURL: '',
    timeout: 5000
})
mockRequest.interceptors.response.use(res=>{
    if(res.data.code===200){
        return Promise.resolve(res.data.data)
    }
    return Promise.reject(res.data)
},err=>{
    return Promise.reject(err)
});
export default mockRequest
