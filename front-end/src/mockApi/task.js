import mockRequest from "../utils/mockRequest";

export function taskList() {
    return mockRequest({
        url: '/task/list',
        method: 'get',
    })
}
