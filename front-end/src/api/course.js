import request from "../utils/request";

export function courseList() {
    return request({
        url: '/course/list',
        method: 'get',
    })
}
export function courseInsert(data) {
    return request({
        url: '/course/insert',
        method: 'post',
        data:data
    })
}
export function courseRemove(obj) {
    return request({
        url: '/course/remove',
        method: 'get',
        params:obj
    })
}
export function courseUpdate(obj) {
    return request({
        url: '/course/update',
        method: 'post',
        data:obj
    })
}
export function courseOwnList(obj) {
    return request({
        url: '/course/ownList',
        method: 'get',
        params: obj
    })
}
export function memCourseList() {
    return request({
        url: '/course/memList',
        method: 'get',
    })
}
