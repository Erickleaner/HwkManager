import mockRequest from "../utils/mockRequest";

export function leaHmkList() {
    return mockRequest({
        url: '/leaHmk/list',
        method: 'get',
    })
}
