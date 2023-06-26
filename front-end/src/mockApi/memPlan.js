import mockRequest from "../utils/mockRequest";

export function memPlanList() {
    return mockRequest({
        url: '/memPlan/list',
        method: 'get',
    })
}
