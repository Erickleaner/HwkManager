import mockRequest from "../utils/mockRequest";

export function leaTaskList() {
    return mockRequest({
        url: '/leaTask/list',
        method: 'get',
    })
}
