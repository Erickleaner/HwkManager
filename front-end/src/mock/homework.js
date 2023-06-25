import Mock from "mockjs";

const homeworks = [
    {
        'homeworkId': 1,
        'name': '酒店系统设计与实现',
        'desc': '要求使用JSP+Servlet实现',
        'groupNum': 9,
        'startTime': '2023-6-12',
        'endTime': '2023-6-21',
    },
    {
        'homeworkId': 2,
        'name': '机场售票系统设计与实现',
        'desc': '要求使用SpringBoot做前后端分离',
        'groupNum': 10,
        'startTime': '2023-6-12',
        'endTime': '2023-6-21',
    },
]
Mock.mock(`/homework/list`, 'get', (options) => {
    return{
        code:200,
        data:homeworks
    }
})
