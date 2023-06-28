import mockRequest from "../utils/mockRequest";

export function leaScoreList() {
    return mockRequest({
        url: '/leaScore/list',
        method: 'get',
    })
}
