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
import {getUser} from "../../../storage";

$('#root').html(main)

const initUI = () =>{
    const {name} = getUser()
    $('.name').text(name)
}
const initEvent = () =>{
    $('#loginOut').click((event)=>{
        event.preventDefault();
        redirectLogin()
    })

    $("#self-info").click((event)=>{
        event.preventDefault(); // 阻止默认的跳转行为
        infoInit()
    })
}

initUI()
initEvent()


