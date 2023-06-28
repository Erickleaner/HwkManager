import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import {taskInsert, taskPublish, taskTeaList} from "../../../../api/task";
import edit from "./edit.html";
import {dateStr} from "../../../../utils/string";


const frame = {
    idField:'taskId',
    insertBtn:'添加任务',
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
            field: 'detail',
            align: 'center'
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
            title: '发布状态',
            field: 'publish',
            align: 'center',
            formatter: function (value) {
                return value===0? '否':'是'
            },
        },
        {
            title: '操作',
            align: 'center',
            formatter: function (value,row) {
                const isPublish = row.publish === 1
                if (!isPublish) {
                    return '<a href="#" class="operate-publish mr-15">发布</a>'
                }else {
                    return '无'
                }
            },
            events: {
                'click .operate-publish': function (e, value, row, index) {
                    e.preventDefault()
                    isSubmit(row)
                },
            }
        },
    ],
}

const Operate = {
    INSERT:'INSERT',
    PUBLISH:'PUBLISH'
}

const isSubmit = (row) =>{
    $('#myModalLabel').text('发布任务')
    $(".modal-body").html('是否确认发布？')
    $('#confirm').data('operate',Operate.PUBLISH).data('row',row);
    $('#myModal').modal('show')
}

const initConfirm = () => {
    $('#confirm').click(function() {
        const operate = $(this).data('operate');
        if (operate===Operate.INSERT){
            const row = emptyRow();
            bindEdit(row)
            row.homeworkId = global.homeworkId
            taskInsert(row).then(data=>{
                if (data.insert){
                    row.taskId = data.insertId
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('append', row);
                    alert('添加任务成功！')
                }else {
                    $('#myModal').modal('hide')
                    alert('添加任务失败！')
                }
            })
        }
        if (operate===Operate.PUBLISH){
            const row = $(this).data('row');
            const taskId = row.taskId
            taskPublish({taskId}).then(data=>{
                if (data){
                    row.publish = 1
                    $('#table_server').bootstrapTable('updateByUniqueId', {
                        [frame.idField]: row[frame.idField],
                        row: row
                    });
                    alert('发布任务成功！')
                }else {
                    alert('发布任务失败！')
                }
                $('#myModal').modal('hide')
            })
        }
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
const emptyRow = () =>{
    return{
        name:'',
        detail:'',
        startTime:null,
        endTime:null,
    }
}
const bindEdit = (row) =>{
    for (const key in row){
        if (key===frame.idField) continue
        row[key] = $(`[name="${key}"]`).val();
    }
}
const initInsert = () =>{
    $('#insertElem').text(frame.insertBtn).click(()=>{
        $('#myModalLabel').text('添加任务')
        $(".modal-body").html(edit)
        $('#confirm').data('operate',Operate.INSERT);
        $('#myModal').modal('show')
    })
}
const initTableByBack = (obj) =>{
    const {row} = obj
    const homeworkId = row.homeworkId;
    taskTeaList({homeworkId}).then(data=>{
        initTable(data)
    })
}
const initUI = (obj) =>{
    const {row,more} = obj
    global.homeworkId = row.homeworkId
    $('[name="courseName"]').val(more.course.name)
    $('[name="clazzName"]').val(more.clazz.name)
    $('[name="hmkName"]').val(row.name)
}
let global = {
    homeworkId:null
}
const norTaskInit = (obj) =>{
    if (obj===null||obj===undefined){
        alert('请选择大作业进入')
        return
    }
    $('#main').html(main)
    initUI(obj)
    initTableByBack(obj)
    initConfirm()
    initInsert()
}
export default norTaskInit
