import generateJoke from "./generateJoke";
import laughing from '../../../assets/image/laughing.png'

const laughImg = document.getElementById('laughImg')
laughImg.src = laughing


const jokeBtn = document.getElementById('jokeBtn')
jokeBtn.addEventListener('click',generateJoke)
generateJoke()
console.log('index')
