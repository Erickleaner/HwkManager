import mockRequest from "../utils/mockRequest";

export function memTaskList() {
    return mockRequest({
        url: '/memTask/list',
        method: 'get',
    })
}
