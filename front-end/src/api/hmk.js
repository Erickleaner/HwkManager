import request from "../utils/request";

export function hmkTeachList(obj) {
    return request({
        url: '/hmk/teachList',
        method: 'post',
        data: obj
    })
}
export function hmkInsert(data) {
    return request({
        url: '/hmk/insert',
        method: 'post',
        data:data
    })
}
export function hmkList() {
    return request({
        url: '/hmk/list',
        method: 'get',
    })
}
export function hmkSave(obj) {
    return request({
        url: '/hmk/save',
        method: 'post',
        data: obj
    })
}

export function hmkSubmit(obj) {
    return request({
        url: '/hmk/submit',
        method: 'get',
        params:obj
    })
}
