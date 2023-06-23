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

$('#root').html(main)

speCourseInit()

$("#self-info").click((event)=>{
    event.preventDefault(); // 阻止默认的跳转行为
    infoInit()
})
$("#spe_course").click((event)=>{
    event.preventDefault(); // 阻止默认的跳转行为
    speCourseInit()
})
