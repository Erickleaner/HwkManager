import Mock from "mockjs";

const taskList = [
    {
        'planId': 1,
        'name': '前台用户管理_计划01',
        'desc': '完成有关于前台用户管理有关业务的部分',
        'startTime': '2023-6-12',
        'endTime': '2023-6-14',
        'completed':0,
    },
    {
        'planId': 2,
        'name': '前台用户管理_计划02',
        'desc': '完成有关于前台用户管理有关数据库的部分',
        'startTime': '2023-6-12',
        'endTime': '2023-6-14',
        'completed':0,
    },

]
Mock.mock(`/memPlan/list`, 'get', (options) => {
    return{
        code:200,
        data:taskList
    }
})
