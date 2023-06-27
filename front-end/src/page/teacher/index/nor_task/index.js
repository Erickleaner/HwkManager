import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import norTeamInit from "../nor_team";
import {taskList} from "../../../../mockApi/task";


const frame = {
    idField:'taskId',
    insertBtn:'添加任务',
    operate:{
        list:taskList,
    },
    columns: [
        {
            title: '序号',
            align: 'center',
            formatter: function(value, row, index) {
                return index + 1;
            }
        },
        {
            title: '任务名',
            field: 'name',
            align: 'center'
        },
        {
            title: '任务描述',
            field: 'desc',
            align: 'center'
        },
        {
            title: '开始时间',
            field: 'startTime',
            align: 'center'
        },
        {
            title: '截止时间',
            field: 'endTime',
            align: 'center'
        },
        {
            title: '发布状态',
            field: 'isPublish',
            align: 'center',
            formatter: function (value) {
                return value===0? '否':'是'
            },
        },
        {
            title: '操作',
            field: 'isPublish',
            align: 'center',
            formatter: function (value) {
                if (value===0) return '<a href="#" class="operate-update mr-15">修改</a>' +
                    '<a href="#" class="operate-delete" >删除</a>';
                if (value===1) return '无'
            },
            events: {
                'click .operate-update': function (e, value, row, index) {
                    e.preventDefault()
                },
                'click .operate-delete': function (e, value, row, index) {
                    e.preventDefault()
                },
            }
        },
        {
            title: '发布',
            field: 'isPublish',
            align: 'center',
            formatter: function (value) {
                if (value===1) return '<a href="#" class="operate-cancel">取消发布</a>'
                if (value===0) return '<a href="#" class="operate-publish">发布</a>'
            },
            events: {
                'click .operate-task': function (e, value, row, index) {
                    e.preventDefault()
                },
            }
        }
    ],
}

const Operate = {
    REMOVE:'REMOVE',
}

const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
    })
}
const initTable = (data) =>{
    let t = $("#table_server").bootstrapTable({
        data:data,
        height:'auto',
        striped: true,//设置为 true 会有隔行变色效果
        undefinedText: "空",//当数据为 undefined 时显示的字符
        pagination: true, //分页
        showColumns: "true",//是否显示 内容列下拉框
        pageNumber: 1,//如果设置了分页，首页页码
        pageSize: 5,//如果设置了分页，页面数据条数
        pageList: [5, 10],	//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
        paginationPreText: '‹',//指定分页条中上一页按钮的图标或文字,这里是<
        paginationNextText: '›',//指定分页条中下一页按钮的图标或文字,这里是>
        data_local: "zh-US",//表格汉化
        uniqueId: frame.idField,
        columns: [
            {
                field: frame.idField,
                visible: false
            },
            ...frame.columns
        ]
    });
}
const initInsert = () =>{
    $('#insertElem').text(frame.insertBtn).click(()=>{
        norTeamInit(null)
    })
}
const initTableByBack = () =>{
    frame.operate.list().then(data => {
        initTable(data)
    })
}
const norTaskInit = () =>{
    $('#main').html(main)
    initTableByBack()
    initConfirm()
    initInsert()
}
export default norTaskInit
