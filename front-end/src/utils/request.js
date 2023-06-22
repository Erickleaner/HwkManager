import axios from 'axios'

const request = axios.create({
  baseURL: '/api',
  timeout: 5000
})
request.interceptors.response.use(res=>{
  if(res.data.code===200){
    return Promise.resolve(res.data.data)
  }
  return Promise.reject(res.data)
},err=>{
  return Promise.reject(err)
});


export default request

