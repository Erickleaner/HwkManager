
export const saveUser = (user) => {
    localStorage.setItem('localUser', JSON.stringify(user));
}
export const getUser = () => {
    return JSON.parse(localStorage.getItem('localUser'));
}
export const removeUser = () => {
    localStorage.removeItem('localUser');
}
export const teaIdFromUser = () => {
    const teacher = JSON.parse(localStorage.getItem('localUser'));
    return teacher.teacherId
}
