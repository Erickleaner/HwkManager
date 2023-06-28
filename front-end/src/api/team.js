import request from "../utils/request";

export function teamInsert(obj) {
    return request({
        url: '/team/insert',
        method: 'post',
        data:obj
    })
}
export function teamUpdate(obj) {
    return request({
        url: '/team/update',
        method: 'post',
        data:obj
    })
}
export function teamRemove(obj) {
    return request({
        url: '/team/remove',
        method: 'get',
        params:obj
    })
}
export function teamList(obj) {
    return request({
        url: '/team/list',
        method: 'get',
        params:obj
    })
}
