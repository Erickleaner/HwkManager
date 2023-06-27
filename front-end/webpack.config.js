const path = require('path')
const {pageHome} = require('./src/config/pageConfig')
const {getEntryObj} = require('./src/config/pageConfig')
const {getTemplateArr} = require('./src/config/pageConfig')
const webpack = require("webpack");
const entryObj = getEntryObj();
const templateArr = getTemplateArr()
module.exports = {
    mode: "development",
    entry: {
        ...entryObj
    },
    output: {
        path: path.resolve(__dirname,"dist"),
        filename: "[name].js",
        assetModuleFilename: "[name]_[contenthash][ext]",
        clean: true,
    },
    devtool: 'source-map',
    //设置static避免404页面的发送
    //index会自己补充上html的后缀
    devServer: {
        proxy:{
            '/api': {
                //要访问的跨域的域名
                target: 'http://127.0.0.1:80',
                ws: true,
                secure:false, // 使用的是http协议则设置为false，https协议则设置为true
                changOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        },
        static: {
            directory: path.resolve(__dirname,`dist/${pageHome.parent}`),
        },
        port: 3000,
        open: true,
        hot: true,
        compress: true,
        historyApiFallback :{
            index: `/${pageHome.name}.html`
        }
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader",
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.(png|svg|jpg|jpeg|gif)$/i,
                type: "asset/resource"
            },
            {
                test: /\.css$/i,
                use: ["style-loader", "css-loader"],
            },
            {
                test: /\.html$/,
                use: ['html-loader'],
            },
        ]
    },
    plugins: [
        ...templateArr,
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery'
        })
    ]

}
