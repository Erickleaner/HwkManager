import Mock from "mockjs";

const taskList = [
    {
        'taskId': 1,
        'name': '需求分析',
        'desc': '完成酒店管理系统的需求分析',
        'startTime': '2023-6-12',
        'endTime': '2023-6-14',
        'subTask': {
            'completedNum':0,
            'splitNum':2,
        },
        'completed':0,
    },
    {
        'taskId': 2,
        'name': '界面设计',
        'desc': '完成酒店管理系统的界面设计',
        'startTime': '2023-6-15',
        'endTime': '2023-6-18',
        'subTask': {
            'completedNum':1,
            'splitNum':3,
        },
        'completed':1,
    },

]
Mock.mock(`/leaTask/list`, 'get', (options) => {
    return{
        code:200,
        data:taskList
    }
})
