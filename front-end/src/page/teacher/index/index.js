import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import '../../../assets/css/frame.css'
import './main.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
import '../../../mock/teacher'

import infoInit from './info'
import speCourseInit from './spe_course'
import {redirectLogin} from "../../../tool/redirect";
import {getUser} from "../../../storage";
import speClazzInit from "./spe_clazz";
import speStudentInit from "./spe_student";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const initEvent = () => {
    $('#loginOut').click(()=>{
        event.preventDefault();
        redirectLogin()
    })

    $("#self-info").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        infoInit()
    })
    $("#spe_course").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        speCourseInit()
    })
    $("#spe_clazz").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        speClazzInit()
    })
    $("#spe_student").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        speStudentInit()
    })
}
speStudentInit()
initUI();
initEvent();
