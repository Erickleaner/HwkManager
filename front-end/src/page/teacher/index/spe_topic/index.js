import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/src/locale/bootstrap-table-zh-CN'
import edit from './edit.html'
import { majorOptions} from "../../../../api/major";
import {topicInsert, topicList, topicRemove, topicUpdate} from "../../../../api/topic";
let optionMap = new Map()
const Operate = {
    REMOVE:'REMOVE',
    UPDATE:'UPDATE',
    INSERT:'INSERT',
}
const isDelete = (row) =>{
    $('#myModalLabel').text('删除数据')
    $(".modal-body").html('是否确定删除？')
    $('#confirm').data('operate',Operate.REMOVE).data('row',row);
    $('#myModal').modal('show')
}
/*const initSelect = () =>{
    optionMap.forEach(function(text, value) {
        const element = $('<option>').text(text).val(value);
        $("[name='majorId']").append(element)
    });

}*/
const initEdit = (row) =>{
    initSelect()
    for (const key in row){
        if (key==='topicId') continue
        let value = row[key]
        $(`[name="${key}"]`).val(value)
    }
}
/*const bindEdit = (row) =>{
    for (const key in row){
        if (key==='topicId') continue
        let value = $(`[name="${key}"]`).val();
        if (key==='majorId') value = parseInt(value)
        row[key] = value
    }
}*/
const isUpdate = (row) =>{
    $('#myModalLabel').text('更新数据')
    $(".modal-body").html(edit)
    initEdit(row);
    $('#confirm').data('operate',Operate.UPDATE).data('row',row);
    $('#myModal').modal('show')

}
const isInsert = () =>{
    $('#myModalLabel').text('添加数据')
    $(".modal-body").html(edit)
    initSelect()
    let row = emptyRow()
    bindEdit(row)
    $('#confirm').data('operate',Operate.INSERT).data('row',row);
    $('#myModal').modal('show')
}
const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
        if (operate===Operate.UPDATE){
            bindEdit(row)
            topicUpdate(row).then(data =>{
                if (data){
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('updateByUniqueId', {
                        topicId: row.topicId,
                        row: row
                    });
                }else {
                    $('#myModal').modal('hide')
                    alert('更新数据失败！')
                }
            })
        }
        if (operate===Operate.REMOVE){
            const topicId = row.topicId
            topicRemove({topicId}).then(data => {
                if (data){
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('remove', {
                        field: 'topicId',
                        values: [row.topicId]
                    });
                }else {
                    $('#myModal').modal('hide')
                    alert('删除数据失败!')
                }
            })
        }
        if (operate===Operate.INSERT){
            row = emptyRow();
            bindEdit(row)
            topicInsert(row).then(data=>{
                if (!data.isInsert){
                    row.topicId = data.insertId
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
        uniqueId: 'topicId',
        columns: [
            {
                field: 'topicId',
                visible: false
            },
            {
                title: '序号',
                align: 'center',
                formatter: function(value, row, index) {
                    return index + 1;
                }
            },
            {
                title: '课程',
                field: 'courseName',
                align: 'center'
            },
            {
                title: '题目',
                field: 'topicName',
                align: 'center'
            },
            {
                title: '指导老师',
                field: 'teacher',
                align: 'center'
            },
            {
                title: '要求',
                field: 'detail',
                align: 'center'
            },
            {
                title: '开始时间',
                field: 'startdate',
                align: 'center'
            },
            {
                title: '结束时间',
                field: 'endate',
                align: 'center',
                formatter: function(value) {
                    return  optionMap.get(value)
                }
            },
            {
                title: '操作',
                align: 'center',
                formatter: function () {
                    return '<a href="#" class="operate-update mr-15">修改</a>' +
                        '<a href="#" class="operate-delete" >删除</a>';
                },
                events: {
                    'click .operate-update': function (e, value, row) {
                        e.preventDefault()
                        isUpdate(row)
                    },
                    'click .operate-delete': function (e, value, row) {
                        e.preventDefault()
                        isDelete(row)
                    }
                }
            }
        ],
    });
}
const emptyRow = () =>{
    return {
        'topicId': null,
        'course_name':'',
        'topic_name':'',
        'course_teacher':'',
        'detail':'',
        'startdate':'',
        'endate':'',
    }
}
const initInsert = () =>{
    $('#insertTopic').click(()=>{
        isInsert()
    })
}
const initTableByBack = () =>{
    topicList().then(data => {
        initTable(data)
    })
}
const initOptions = () =>{
    return majorOptions().then(data=>{
        let optionArr = [...data]
        optionArr.forEach(option=>{
            const {value,text} = option
            optionMap.set(value, text);
        })
    })
}
const speTopicInit = () =>{
    $('#main').html(main)
    initOptions().then(()=>{
        initTableByBack()
    })
    initConfirm()
    initInsert()
}
export default speTopicInit
