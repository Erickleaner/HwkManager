
export const saveUser = (user) => {
    localStorage.setItem('localUser', JSON.stringify(user));
}
export const getUser = () => {
    return JSON.parse(localStorage.getItem('localUser'));
}
export const removeUser = () => {
    localStorage.removeItem('localUser');
}
