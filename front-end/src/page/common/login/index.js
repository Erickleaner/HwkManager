import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import './main.css'
import '../../../mock/user'
import {login} from "../../../api/login";

$('#root').html(main)
//login submit
const loginSubmit = () =>{
    const userName = $('input[name="userName"]').val();
    const passWord = $('input[name="passWord"]').val();
    const role = $('input[name="role"]:checked').val();
    console.log(userName)
    console.log(passWord)
    console.log(role)
    login({userName,passWord,role}).then(data=>{
        console.log(data)
        const {isLogin,msg} = data
        if (!isLogin){
            $('#myModalLabel').text('删除数据')
            $(".modal-body").text(msg)
            $('#myModal').modal('show')
        }else {
            if (role==='teacher'){
                $.redirect("https://www.example.com");
            }
            if (role==='student'){

            }
            if (role==='leader'){

            }
        }
    })
}
$('#loginForm').submit(function(event) {
    // 阻止默认的表单提交行为
    event.preventDefault()
    loginSubmit()
})
