import request from "../utils/request";

export function taskList() {
    return request({
        url: '/task/list',
        method: 'get',
    })
}
export function taskInsert(data) {
    return request({
        url: '/task/insert',
        method: 'post',
        data:data
    })
}
export function taskRemove(obj) {
    return request({
        url: '/task/remove',
        method: 'get',
        params:obj
    })
}
export function taskUpdate(obj) {
    return request({
        url: '/task/update',
        method: 'post',
        data:obj
    })
}

