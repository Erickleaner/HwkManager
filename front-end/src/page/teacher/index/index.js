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
import {getUser, removeUser} from "../../../storage";
import speClazzInit from "./spe_clazz";
import speStudentInit from "./spe_student";
import norTeachInit from "./nor_teach";
import templateInit from "./template";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const initNormal = () =>{
    $('#loginOut').click(()=>{
        event.preventDefault();
        removeUser()
        redirectLogin()
    })
    $("#nor_teach").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        norTeachInit()
    })
}
const initSpecial = () =>{
    const {power} = getUser()
    if (power === 'special') $('#special').show()
    $("#self_info").click((event)=>{
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
const initEvent = () => {
    initNormal()
    initSpecial()
}
templateInit()
initUI();
initEvent();
