import mockRequest from "../utils/mockRequest";

export function login(obj) {
    return mockRequest({
        url: '/user/login',
        method: 'post',
        data: obj
    })
}
