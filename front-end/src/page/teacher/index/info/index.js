import './main.css'
import main from './main.html'
import item from './item.html'

const infoInit = () =>{
    $('#main').html(main)
    $('#tableClass').append(item)
}
export default infoInit
