import Mock from "mockjs";

const courses = [
    {
        'courseId': 1,
        'name': '操作系统',
        'teacherName':'张三',
        'serialNum':'01',
        'score':4,
        'stuTime':24,
        'semester':'2-up',
    },
    {
        'courseId': 2,
        'name': '数据库原理',
        'teacherName':'李四',
        'serialNum':'02',
        'score':4,
        'stuTime':18,
        'semester':'2-down',
    },
]
Mock.mock(`/memCourse/list`, 'get', (options) => {
    return{
        code:200,
        data:courses
    }
})
