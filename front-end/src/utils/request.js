import axios from 'axios'

const request = axios.create({
  baseURL: '/api',
  timeout: 5000
})
request.interceptors.response.use(res=>{
  if(res.data.code===200){
    return Promise.resolve(res.data.data)
  }
  alert('网络错误或者返回值有误')
},err=>{
  alert('网络错误或者返回值有误')
  //return Promise.reject(err)
});


export default request

