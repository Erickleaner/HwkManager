import request from "../utils/request";

export function taskTeaList(obj) {
    return request({
        url: '/task/teaList',
        method: 'get',
        params:obj
    })
}
export function taskInsert(obj) {
    return request({
        url: '/task/insert',
        method: 'post',
        data:obj
    })
}
export function taskPublish(obj) {
    return request({
        url: '/task/publish',
        method: 'get',
        params:obj
    })
}
