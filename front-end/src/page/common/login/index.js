import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import './main.css'

//mock data
import '../../../mock/user'

import {login, session} from "../../../api/login";
import {redirectStudent, redirectTeacher} from "../../../tool/redirect";
import {getUser, saveUser} from "../../../storage";

$('#root').html(main)

//login submit
const loginSubmit = () =>{
    const username = $('input[name="username"]').val();
    const password = $('input[name="password"]').val();
    const role = $('input[name="role"]:checked').val();
    login({username,password,role}).then(data=>{
        const {isLogin,user} = data
        if (!isLogin){
            $('#myModalLabel').text('登录失败')
            $(".modal-body").text('用户名或者密码错误！')
            $('#myModal').modal('show')
        }else {
            if (role==='student'){
                saveUser(user)
                redirectStudent()
            }
            if (role==='teacher'){
                saveUser(user)
                redirectTeacher()
            }
        }
    })
}
const initEvent = () => {
    $('#loginForm').submit(function(event) {
        // 阻止默认的表单提交行为
        event.preventDefault()
        loginSubmit()
    })
}
const entry = () => {
    session().then(sessionDto=>{
        if(sessionDto===null) return
        const {user,ifLogin} = sessionDto
        if (ifLogin){
            if (user.role==='teacher'){
                saveUser(user)
                redirectTeacher()
            }else {
                saveUser(user)
                redirectStudent()
            }
        }
    })
}
initEvent()
entry()
