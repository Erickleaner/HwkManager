import Mock from "mockjs";

const teams = [
    {
        'teamId': '1',
        'teamOrder':'1',
        'name': '王一番',
        'no':'20201619',
        'grade':'90',
    },
    {
        'teamId': '2',
        'teamOrder':'1',
        'name': '王潮涛',
        'no':'20201618',
        'grade':'89',
    },
/*    {
        'teamId': '1',
        'memberName': '徐伟力',
        'memberNo':'20201622',
        'grade':'88',
    },*/
]
Mock.mock(`/team/list`, 'get', (options) => {
    return{
        code:200,
        data:teams
    }
})
