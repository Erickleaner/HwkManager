import request from "../utils/request";

export function clazzList() {
    return request({
        url: '/clazz/list',
        method: 'get',
    })
}
export function clazzInsert(data) {
    return request({
        url: '/clazz/insert',
        method: 'post',
        data:data
    })
}
export function clazzRemove(obj) {
    return request({
        url: '/clazz/remove',
        method: 'get',
        params:obj
    })
}
export function clazzUpdate(obj) {
    return request({
        url: '/clazz/update',
        method: 'post',
        data:obj
    })
}
export function clazzOptions() {
    return request({
        url: '/clazz/optionList',
        method: 'get',
    })
}
