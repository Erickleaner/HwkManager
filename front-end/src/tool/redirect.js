
const redirectOrigin = (path) =>{
    window.location.href = window.location.origin + path
}
export function redirectLogin(){
    redirectOrigin('/common/login.html')
}
export function redirectStudent(){
    redirectOrigin('/student/index.html')
}
export function redirectTeacher(){
    redirectOrigin('/teacher/index.html')
}
