import request from "../utils/request";

export function login(obj) {
    return request({
        url: '/user/login',
        method: 'post',
        data: obj
    })
}
