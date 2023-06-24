import './main.css'
import main from './main.html'
import {getUser} from "../../../../storage";


const bindInfo = () =>{
    const arr = ['username','name','password']
    const user = getUser()
    for (let i=0;i<arr.length;i++){
        const key = arr[i];
        $(`#${key}`).text(user[key])
    }
}
const infoInit = () =>{
    $('#main').html(main)
    bindInfo()
}
export default infoInit
