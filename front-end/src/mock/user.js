
import Mock from 'mockjs';

const users = [
    {
        userName:'teacher',
        passWord:'123456',
        role:'teacher',
    },
    {
        userName:'20201619',
        passWord:'123456',
        role:'student',
        no:'20201619',
        name:'王一番',
        clazz:'202016',
        grade:3,
        major:'软件工程'
    },
    {
        userName:'20201618',
        passWord:'123456',
        role:'student',
    },
    {
        userName:'20201619',
        passWord:'123456',
        role:'leader',
    },
]

// 模拟登录接口
Mock.mock(`/user/login`, 'post', (options) => {
    const { userName, passWord, role } = JSON.parse(options.body)
    let isLogin = false;
    let msg = ""
    let user = null;
    for (let i=0;i<users.length;i++){
        const item = users[i]
        if (userName === item.userName &&
            passWord === item.passWord &&
            role === item.role)
        {
            isLogin = true
            msg = '登录成功！'
            user = item
            break;
        }
    }
    if (!isLogin) msg = "登录失败，用户名或者密码错误！"
    return {
        code: 200,
        data: {
            isLogin,
            msg,
            user
        }
    }
})
