import mockRequest from "../utils/mockRequest";

export function teamList() {
    return mockRequest({
        url: '/team/list',
        method: 'get',
    })
}
