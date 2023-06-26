import Mock from "mockjs";

const taskList = [
    {
        'taskId': 1,
        'name': '需求分析_前台用户管理',
        'desc': '完成酒店管理系统的前台用户管理的需求分析',
        'startTime': '2023-6-12',
        'endTime': '2023-6-14',
        'plan': {
            'completedNum':0,
            'splitNum':2,
        },
        'completed':0,
    },
    {
        'taskId': 2,
        'name': '界面设计_后台管理',
        'desc': '完成酒店管理系统的后台管理的界面设计',
        'startTime': '2023-6-15',
        'endTime': '2023-6-18',
        'plan': {
            'completedNum':1,
            'splitNum':3,
        },
        'completed':1,
    },

]
Mock.mock(`/memTask/list`, 'get', (options) => {
    return{
        code:200,
        data:taskList
    }
})
