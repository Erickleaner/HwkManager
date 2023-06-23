
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
    console.log(options.body)
    const { userName, passWord, role } = JSON.parse(options.body)
    let isLogin = false;
    let msg = ""
    for (let i=0;i<users.length;i++){
        const user = users[i]
        if (userName === user.userName &&
            passWord === user.passWord &&
            role === user.role)
        {
            isLogin = true
            msg = '登录成功！'
            break;
        }
    }
    if (!isLogin) msg = "登录失败，用户名或者密码错误！"
    return {
        code: 200,
        data: {
            isLogin,
            msg
        }
    }
})
