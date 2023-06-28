import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/src/locale/bootstrap-table-zh-CN'
import {leaHmkList} from "../../../../mockApi/leaHmk";
import memTaskInit from "../mem_task";
import leaTaskInit from "../lea_task";
import {dateStr} from "../../../../utils/string";


const frame = {
    idField:'hmkId',
    operate:{
        list:leaHmkList,
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
            title: '组内身份',
            field: 'ifLeader',
            align: 'center',
            formatter: function(value) {
                if (value) return '组长'
                else return '组员'
            }
        },
        {
            title: '组长职能',
            align: 'center',
            formatter: function (value, row) {
                const ifLeader = row.ifLeader
                if (ifLeader) return '<a href="#" class="operate-leaTask">大作业任务</a>'
                else return '无'
            },
            events: {
                'click .operate-leaTask': function (e, value, row, index) {
                    e.preventDefault()
                    leaTaskInit()
                },
            }
        },
        {
            title: '组员职能',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-memTask">我的任务</a>'
            },
            events: {
                'click .operate-memTask': function (e, value, row, index) {
                    e.preventDefault()
                    memTaskInit()
                },
            }
        }
    ],
}

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
const initEdit = (row) =>{
    for (const key in row){
        if (key===frame.idField) continue
        let value = row[key]
        $(`[name="${key}"]`).val(value)
    }
}
const bindEdit = (row) =>{
    for (const key in row){
        if (key===frame.idField) continue
        row[key] = $(`[name="${key}"]`).val();
    }
}
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
            frame.operate.update(row).then(data =>{
                if (data){
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('updateByUniqueId', {
                        [frame.idField]: row[frame.idField],
                        row: row
                    });
                }else {
                    $('#myModal').modal('hide')
                    alert('更新数据失败！')
                }
            })
        }
        if (operate===Operate.REMOVE){
            const idKey = frame.idField;
            const id = row[idKey]
            frame.operate.remove({[idKey]:id}).then(data => {
                if (data){
                    $('#myModal').modal('hide')
                    $('#table_server').bootstrapTable('remove', {
                        field: idKey,
                        values: [id]
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
            frame.operate.insert(row).then(data=>{
                if (!data.isInsert){
                    row.courseId = data.insertId
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
    return frame.empty
}
const initInsert = () =>{
    $('#insertElem').text(frame.insertBtn).click(()=>{
        isInsert()
    })
}
const initTableByBack = (obj) =>{
    const {ctcId} = obj
    leaHmkList({ctcId}).then(data => {
        initTable(data)
    })
}
const initUI = obj => {
    const {name,teacherName} = obj
    $('[name="courseName"]').val(name)
    $('[name="teacherName"]').val(teacherName)
}
const memHmkInit = (obj) =>{
    if (obj===null||obj===undefined){
        alert('从我的课程入口点击进入')
        return
    }
    $('#main').html(main)
    initTableByBack(obj)
    initUI(obj)
    initConfirm()
    initInsert()
}
export default memHmkInit
