import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import {homeworkList} from "../../../../mockApi/homework";
import norTeamInit from "../nor_team";
import {teaBzTeach} from "../../../../api/teaBusiness";
import {hmkInsert, hmkTeachList} from "../../../../api/hmk";
import edit from "./edit.html";
import {dateStr} from "../../../../utils/string";


const frame = {
    idField:'homeworkId',
    insertBtn:'分组添加',
    operate:{
        list:homeworkList,
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
            title: '大作业名',
            field: 'name',
            align: 'center'
        },
        {
            title: '大作业描述',
            field: 'detail',
            align: 'center'
        },
        {
            title: '分组数',
            field: 'groupNum',
            align: 'center',
            formatter: function (value) {
                if (value===undefined||value===null) return 0
            },
        },
        {
            title: '是否分组发布',
            field: 'publish',
            align: 'center',
            formatter: function (value) {
                return value===0 ? '否':'是'
            },
        },
        {
            title: '开始时间',
            field: 'startTime',
            align: 'center',
            formatter: function (value) {
                return dateStr(value)
            },
        },
        {
            title: '截止时间',
            field: 'endTime',
            align: 'center',
            formatter: function (value) {
                return dateStr(value)
            },
        },
        {
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-task">分组发布</a>'
            },
            events: {
                'click .operate-task': function (e, value, row, index) {
                    e.preventDefault()
                    hmkManage()
                },
            }
        }
    ],
}

const Operate = {
    INSERT:'INSERT',
}
const emptyRow = () =>{
    return{
        name:'',
        detail:'',
        startTime:null,
        endTime:null,
    }
}
const bindRow = (row) => {
    for (const key in row){
        if (key==='homeworkId') continue
        row[key] = $(`[name="${key}"]`).val()
    }
}
const getCtcId = () =>{
    let clazz = JSON.parse($('#selectClazz').val())
    return clazz.ctcId;
}
const initConfirm = () => {
    $('#confirm').click(function() {
        const operate = $(this).data('operate');
        if (operate===Operate.INSERT){
            const row = emptyRow()
            bindRow(row)
            row.ctcId = getCtcId()
            hmkInsert(row).then(data=>{
                if (!data.isInsert){
                    row.homeworkId = data.insertId
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('append', row);
                }else {
                    $('#myModal').modal('hide')
                    alert('添加数据失败！')
                }
            })
        }
    })
}
const loadTable = (data) =>{
    $('#table_server').bootstrapTable('load', data);
}
const initTable = () =>{
    let t = $("#table_server").bootstrapTable({
        data:[],
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
const hmkManage = () =>{
    let teachVo = JSON.parse($('#selectCourse').val())
    const course = teachVo.course
    let clazz  = JSON.parse($('#selectClazz').val())
    norTeamInit({course,clazz})
}
const initInsert = () =>{
    $('#insertElem').text(frame.insertBtn).click(()=>{
        $('#myModalLabel').text('添加大作业')
        $(".modal-body").html(edit)
        $('#confirm').data('operate',Operate.INSERT);
        $('#myModal').modal('show')
    })
}
let teachVoList = []
const initSelector = () =>{
    teachVoList.forEach(item=>{
        const course = item.course
        const option = $('<option>').text(course.name).val(JSON.stringify(item));
        $('#selectCourse').append(option)
    })
}
const initCurrentClazz = () => {
    const teachVo = JSON.parse($('#selectCourse').val())
    $('#selectClazz').html('')
    new Promise(resolve => {
        teachVo.clazzList.forEach(clazz=>{
            const option = $('<option>').text(clazz.name).val(JSON.stringify(clazz));
            $('#selectClazz').append(option)
        })
        resolve()
    }).then(()=>{
        let teachVo  = JSON.parse($('#selectCourse').val())
        let clazz  = JSON.parse($('#selectClazz').val())
        const tc = teachVo.tc
        hmkTeachList({clazz,tc}).then(data=>{
            console.log(data)
            loadTable(data)
        })
    })
}
const initTeach = () =>{
    teaBzTeach().then(data=>{
        teachVoList = data
    }).then(()=>{
        initSelector()
        initCurrentClazz()
    })
}
const listenSelector = () =>{
    $('#selectCourse').change(val=>{
        initCurrentClazz()
    })
}
const norHmkInit = () =>{
    $('#main').html(main)
    initConfirm()
    initInsert()
    initTeach()
    listenSelector()
    initTable()
}
export default norHmkInit
