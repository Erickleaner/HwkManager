import '../../../assets/css/global.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import main from './main.html'
import '../../../assets/css/frame.css'
import './main.css'
import '@fortawesome/fontawesome-free/css/all.min.css'
import '../../../mock/teacher'
import infoInit from './info'
$('#root').html(main)

$("#self-info").click((event)=>{
    event.preventDefault(); // 阻止默认的跳转行为
    infoInit()
})
