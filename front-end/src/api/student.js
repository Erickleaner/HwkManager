import request from "../utils/request";

export function studentList() {
    return request({
        url: '/student/list',
        method: 'get',
    })
}
export function studentInsert(data) {
    return request({
        url: '/student/insert',
        method: 'post',
        data:data
    })
}
export function studentRemove(obj) {
    return request({
        url: '/student/remove',
        method: 'get',
        params:obj
    })
}
export function studentUpdate(obj) {
    return request({
        url: '/student/update',
        method: 'post',
        data:obj
    })
}
export function studentListByClazz(obj) {
    return request({
        url: '/student/searchList',
        method: 'get',
        params: obj
    })
}
