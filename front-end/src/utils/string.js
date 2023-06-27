export const semesterStr = (str) =>{
    let arr = str.split('-');
    if (arr[0]==='1') arr[0] = '大一'
    if (arr[0]==='2') arr[0] = '大二'
    if (arr[0]==='3') arr[0] = '大三'
    if (arr[0]==='4') arr[0] = '大四'
    if (arr[1]==='up') arr[1] = '上'
    if (arr[1]==='down') arr[1] = '下'
    return arr[0]+arr[1]
}
export const gradeStr = (str) =>{
    if (str===1) return '大一'
    if (str===2) return '大二'
    if (str===3) return '大三'
    if (str===4) return '大四'
    return str
}
export const dutyStr = (str) =>{
    if (str==='leader') return '组长'
    if (str==='member') return '组员'
}
export const dateStr = (dateStr) =>{
    const date = new Date(dateStr);
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate();
    return `${year}-${month}-${day}`;
}
