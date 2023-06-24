import './main.css'
import main from './main.html'
import {getUser} from "../../../../storage";
import {gradeStr} from "../../../../utils/string";


const bindInfo = () =>{
    const info = getUser()
    let attrs = ['no','name','clazz','grade','major','passWord']
    for (let i=0;i<attrs.length;i++){
        const key = attrs[i]
        let value = info[key];
        if (key==='grade') value = gradeStr(value)
        $(`#${key}`).text(value)
    }
}
const infoInit = () =>{
    $('#main').html(main)
    bindInfo()
}
export default infoInit
