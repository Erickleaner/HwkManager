import mockRequest from "../utils/mockRequest";

export function mockCourseList() {
    return mockRequest({
        url: '/course/list',
        method: 'get',
    })
}
