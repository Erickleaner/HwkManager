import mockRequest from "../utils/mockRequest";

export function homeworkList() {
    return mockRequest({
        url: '/homework/list',
        method: 'get',
    })
}
