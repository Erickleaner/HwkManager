import Mock from "mockjs";

const hmkList = [
    {
        'hmkId': 1,
        'name': '酒店系统设计与实现',
        'detail': '要求使用JSP+Servlet实现',
        'startTime': '2023-6-12',
        'endTime': '2023-6-21',
        'identity':'leader'
    },
    {
        'hmkId': 2,
        'name': '机场售票系统设计与实现',
        'detail': '要求使用SpringBoot做前后端分离',
        'startTime': '2023-6-12',
        'endTime': '2023-6-21',
        'identity':'member'
    },
]
Mock.mock(`/leaHmk/list`, 'get', () => {
    return{
        code:200,
        data:hmkList
    }
})
