import request from "../utils/request";

export function topicList() {
    return request({
        url: '/topic/list',
        method: 'get',
    })
}
export function topicInsert(data) {
    return request({
        url: '/topic/insert',
        method: 'post',
        data:data
    })
}
export function topicRemove(obj) {
    return request({
        url: '/topic/remove',
        method: 'get',
        params:obj
    })
}
export function topicUpdate(obj) {
    return request({
        url: '/topic/update',
        method: 'post',
        data:obj
    })
}
export function topicOptions() {
    return request({
        url: '/topic/optionList',
        method: 'get',
    })
}
