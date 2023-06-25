import request from "../utils/request";

export function tcList() {
    return request({
        url: '/tc/list',
        method: 'get',
    })
}
export function tcInsert(data) {
    return request({
        url: '/tc/insert',
        method: 'post',
        data:data
    })
}
export function tcRemove(obj) {
    return request({
        url: '/tc/remove',
        method: 'get',
        params:obj
    })
}
export function tcUpdate(obj) {
    return request({
        url: '/tc/update',
        method: 'post',
        data:obj
    })
}
