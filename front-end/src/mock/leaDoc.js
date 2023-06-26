import Mock from "mockjs";

const docList = [
    {
        'docId': 1,
        'name': '需求分析',
        'author':'张三',
        'submitTime':'2023-6-20',
        'parentHmk':'酒店管理系统的设计与实现',
        'publishState':0,

    },
    {
        'docId': 2,
        'name': '可行性分析',
        'author':'张三',
        'submitTime':'2023-6-25',
        'parentHmk':'酒店管理系统的设计与实现',
        'publishState':0,
    },
    {
        'docId': 3,
        'name': '调查分析',
        'author':'张三',
        'submitTime':'2023-6-25',
        'parentHmk':'酒店管理系统的设计与实现',
        'publishState':0,
    },

]
Mock.mock(`/leaDoc/list`, 'get', (options) => {
    return{
        code:200,
        data:docList
    }
})