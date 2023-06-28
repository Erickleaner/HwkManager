import request from "../utils/request";

export function login(obj) {
    return request({
        url: '/user/login',
        method: 'post',
        data: obj
    })
}
export function session() {
    return request({
        url: '/user/session',
        method: 'get',
    })
}
export function quit() {
    return request({
        url: '/user/quit',
        method: 'get',
    })
}
