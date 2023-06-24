const HtmlWebpackPlugin = require('html-webpack-plugin')
const pageHome = {
    parent:'common',
    name:'login',
}
const pageConfig = {
    common: [
        {
            name:'login',
        },
    ],
    teacher: [
        {
            name:'index',
        },
    ],
    student: [
        {
            name:'index',
        },
    ],
}
const getEntryObj = () => {
    let entryObj = {}
    for (const key in pageConfig){
        const itemArr = pageConfig[key]
        itemArr.forEach(item => {
            const name = item.name;
            const objKey = `${key}_${name}`
            entryObj[objKey] = `./src/page/${key}/${name}/index.js`
        })
    }
    return entryObj;
}
const getTemplateArr = () => {
    let arr = []
    for (const key in pageConfig){
        const itemArr = pageConfig[key]
        itemArr.forEach(item => {
            const name = item.name;
            const chunk = `${key}_${name}`
            arr.push(
                new HtmlWebpackPlugin(
                    {
                        template: `./src/page/index.html`,
                        filename: `${key}/${name}.html`,
                        chunks: [chunk],
                    }
                )
            )
        })
    }
    return arr
}
module.exports = {
    getEntryObj,
    getTemplateArr,
    pageHome
};
