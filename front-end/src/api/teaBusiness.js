import request from "../utils/request";


export function teaBusinessAcquire(data) {
    return request({
        url: '/teaBusiness/acquire',
        method: 'post',
        data:data
    })
}
export function teaBzTeach() {
    return request({
        url: '/teaBusiness/teach',
        method: 'get',
    })
}
