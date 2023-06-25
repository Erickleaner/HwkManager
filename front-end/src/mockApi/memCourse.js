import mockRequest from "../utils/mockRequest";

export function memCourseList() {
    return mockRequest({
        url: '/memCourse/list',
        method: 'get',
    })
}
