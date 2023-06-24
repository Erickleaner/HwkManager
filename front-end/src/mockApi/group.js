import mockRequest from "../utils/mockRequest";

export function groupList() {
    return mockRequest({
        url: '/group/list',
        method: 'get',
    })
}
