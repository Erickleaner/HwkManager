import Mock from "mockjs";

let myCourses = [
    {
        'courseId': 1,
        'name': '操作系统',
        'serialNum':'01',
        'clazzNum':2,
        'score':4,
        'stuTime':24,
        'semester':'2-up',
    },
    {
        'courseId': 2,
        'name': '数据库原理',
        'serialNum':'02',
        'clazzNum':3,
        'score':6,
        'stuTime':36,
        'semester':'2-down',
    },
]
Mock.mock(`/course/list`, 'get', (options) => {
    //row
    let row = null;
    myCourses.forEach(item=>{
        if (item.courseId===row.courseId)
            item = row
    })
    return{
        code:200,
        data:myCourses
    }
})
