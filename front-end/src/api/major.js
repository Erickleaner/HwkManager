import request from "../utils/request";

export function majorOptions() {
    return request({
        url: '/major/optionList',
        method: 'get',
    })
}
