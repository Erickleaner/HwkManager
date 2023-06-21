import generateJoke from "./generateJoke";
import laughing from '../../../assets/image/laughing.png'
import main from './main.html'
import 'bootstrap/dist/css/bootstrap.min.css'
import './style.css'

let root = document.getElementById('root')
root.innerHTML = main

const laughImg = document.getElementById('laughImg')
laughImg.src = laughing

const jokeBtn = document.getElementById('jokeBtn')
jokeBtn.onclick = generateJoke
generateJoke()

