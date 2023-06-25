import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import '../../../assets/css/frame.css'
import './main.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
//mock data


import infoInit from './info'
import {redirectLogin} from "../../../tool/redirect";
import {getUser, removeUser} from "../../../storage";
import speCourseInit from "../../teacher/index/spe_course";
import speClazzInit from "../../teacher/index/spe_clazz";
import speStudentInit from "../../teacher/index/spe_student";
import norTeachInit from "../../teacher/index/nor_teach";
import norCourseInit from "../../teacher/index/nor_course";
import norHmkInit from "../../teacher/index/nor_hmk";
import norGroupInit from "../../teacher/index/nor_group";
import norTaskInit from "../../teacher/index/nor_task";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const leaderEvent = [
    {
        id:'lea_course',
        action:speCourseInit,
    },
]
const memberEvent = [
    {
        id:'self_info',
        action:infoInit,
    },
    {
        id:'loginOut',
        action:()=>{
            removeUser()
            redirectLogin()
        }
    },
]
const initMember = () =>{
    memberEvent.forEach(item=>{
        $(`#${item.id}`).click(()=>{
            event.preventDefault();
            item.action()
        })
    })
}
const initLeader = () =>{
    leaderEvent.forEach(item=>{
        $(`#${item.id}`).click(()=>{
            event.preventDefault();
            item.action()
        })
    })
}
const initEvent = () => {
    initMember()
    initLeader()
}
initUI();
initEvent();
