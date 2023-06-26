import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import '../../../assets/css/frame.css'
import './main.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
//mock data
import '../../../mock/memCourse'
import '../../../mock/leaHmk'
import '../../../mock/leaTask'
import '../../../mock/memTask'

import infoInit from './info'
import {redirectLogin} from "../../../tool/redirect";
import {getUser, removeUser} from "../../../storage"
import memCourseInit from "./mem_course";
import memTaskInit from "./mem_task";
import memPlanInit from "./mem_plan";
import memHmkInit from "./mem_hmk";
import leaTaskInit from "./lea_task";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const commonEvent =[
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
const leaderEvent = [
    {
        id:'lea_task',
        action:leaTaskInit,
    },
]
const memberEvent = [
    {
        id:'mem_course',
        action:memCourseInit,
    },
    {
        id:'mem_task',
        action:memTaskInit,
    },
    {
        id:'mem_plan',
        action:memPlanInit,
    },
    {
        id:'mem_hmk',
        action:memHmkInit,
    },
]
const initCommon = () =>{
    commonEvent.forEach(item=>{
        $(`#${item.id}`).click(()=>{
            event.preventDefault();
            item.action()
        })
    })
}
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
    initCommon()
    initMember()
    initLeader()
}
initUI();
initEvent();
leaTaskInit()
