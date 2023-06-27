import Mock from "mockjs";

const tasks = [
    {
        'taskId': 1,
        'name': '需求分析',
        'desc': '完成酒店管理系统的需求分析',
        'startTime': '2023-6-12',
        'endTime': '2023-6-14',
        'isPublish':1,
    },
    {
        'taskId': 2,
        'name': '界面设计',
        'desc': '完成酒店管理系统的界面设计',
        'startTime': '2023-6-15',
        'endTime': '2023-6-18',
        'isPublish':0
    },
]
Mock.mock(`/task/list`, 'get', (options) => {
    return{
        code:200,
        data:tasks
    }
})
