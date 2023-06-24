import Mock from "mockjs";

const groups = [
    {
        'groupId': 1,
        'leaderName': '小明',
        'leaderNo':'20201607',
        'groupNum':3,
    },
    {
        'groupId': 2,
        'leaderName': '小红',
        'leaderNo':'20201624',
        'groupNum':4,
    },
]
Mock.mock(`/group/list`, 'get', (options) => {
    return{
        code:200,
        data:groups
    }
})
