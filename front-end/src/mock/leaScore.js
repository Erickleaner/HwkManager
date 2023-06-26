import Mock from "mockjs";

const scoreList = [
    {
        'scoreId': 1,
        'name': '张三',
        'taskName':'需求分析',
        'score':78,
        'scoreState':0,

    },
    {
        'scoreId': 2,
        'name': '李四',
        'taskName':'需求分析',
        'score':85,
        'scoreState':0,

    },
    {
        'scoreId': 3,
        'name': '王五',
        'taskName':'需求分析',
        'score':90,
        'scoreState':0,

    },
]
Mock.mock(`/leaScore/list`, 'get', (options) => {
    return{
        code:200,
        data:scoreList
    }
})