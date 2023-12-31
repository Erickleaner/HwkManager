import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import '../../../assets/css/frame.css'
import './main.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
//mock data
import '../../../mock/course'
import '../../../mock/homework'
import '../../../mock/group'
import '../../../mock/task'
import '../../../mock/team'

import infoInit from './info'
import speCourseInit from './spe_course'
import {redirectLogin} from "../../../tool/redirect";
import {getUser, removeUser} from "../../../storage";
import speClazzInit from "./spe_clazz";
import speStudentInit from "./spe_student";
import norTeachInit from "./nor_acquire";
import norCourseInit from "./nor_course";
import norHmkInit from "./nor_hmk";
import norTeamInit from "./nor_team";
import norTaskInit from "./nor_task";
import norExamineInit from "./nor_examine";
import {quit} from "../../../api/login";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const specialEvent = [
    {
        id:'spe_course',
        action:speCourseInit,
    },
    {
        id:'spe_clazz',
        action:speClazzInit,
    },
    {
        id:'spe_student',
        action:speStudentInit,
    }

]
const normalEvent = [
    {
        id:'self_info',
        action:infoInit,
    },
    {
        id:'loginOut',
        action:()=>{
            quit().then(data=>{
                if (data){
                    removeUser()
                    redirectLogin()
                }else {
                    alert('退出登录失败')
                }
            })
        }
    },
    {
        id:'nor_teach',
        action:norTeachInit,
    },
    {
        id:'nor_course',
        action:norCourseInit,
    },
    {
        id:'nor_hmk',
        action:norHmkInit,
    },
    {
        id:'nor_group',
        action:()=>{
            norTeamInit(null)
        },
    },
    {
        id:'nor_task',
        action:norTaskInit,
    },
    {
        id:'nor_examine',
        action:norExamineInit,
    }
]
const initNormal = () =>{
    normalEvent.forEach(item=>{
        $(`#${item.id}`).click(()=>{
            event.preventDefault();
            item.action()
        })
    })
}
const initSpecial = () =>{
    const {power} = getUser()
    if (power === 'special') $('#special').show()
    specialEvent.forEach(item=>{
        $(`#${item.id}`).click(()=>{
            event.preventDefault();
            item.action()
        })
    })
}
const initEvent = () => {
    initNormal()
    initSpecial()
}
infoInit()

/*norTeamInit(
    {
        clazz:{name:'202016'},
        course:{name:'操作系统'},
    }
    )*/
initUI();
initEvent();
