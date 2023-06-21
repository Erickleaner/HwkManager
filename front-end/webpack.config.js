const path = require('path')
const webpack = require('webpack');
const {getEntryObj} = require('./src/const/pageConfig')
const {getTemplateArr} = require('./src/const/pageConfig')
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
    devServer: {
        static: {
            directory: path.resolve(__dirname,'dist/student'),
        },
        port: 3000,
        open: true,
        hot: true,
        compress: true,
        historyApiFallback :true,
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
/*        new webpack.HotModuleReplacementPlugin(), // 添加热模块替换插件*/
        ...templateArr
    ]

}