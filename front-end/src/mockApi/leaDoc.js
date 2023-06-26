import mockRequest from "../utils/mockRequest";

export function leaDocList() {
    return mockRequest({
        url: '/leaDoc/list',
        method: 'get',
    })
}
