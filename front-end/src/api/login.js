import request from "../utils/request";

export function login(obj) {
    return request({
        url: '/account/login',
        method: 'post',
        data: obj
    })
}
