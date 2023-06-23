import './main.css'
import main from './main.html'

const info = {
    account:'teacher',
    name:'张三',
    passWord:'123456'
}
const bindInfo = () =>{
    for (const key in info){
        $(`#${key}`).text(info[key])
    }
}
const infoInit = () =>{
    $('#main').html(main)
    bindInfo()
}
export default infoInit
