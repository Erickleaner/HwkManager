import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/src/locale/bootstrap-table-zh-CN'
import {leaTaskList} from "../../../../mockApi/leaTask";


const frame = {
    idField:'taskId',
    operate:{
        list:leaTaskList,
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
            title: '拆分数',
            field: 'subTask.splitNum',
            align: 'center'
        },
        {
            title: '完成数',
            field: 'subTask.completedNum',
            align: 'center'
        },
        {
            title: '完成状态',
            field: 'completed',
            align: 'center',
            formatter: function(value) {
                if (value===0) return'未完成'
                if (value===1) return'已完成'
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-update">拆分任务</a>';
            },
            events: {
                'click .operate-update': function (e, value, row, index) {
                    e.preventDefault()
                    //isUpdate(row)
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
const initTableByBack = () =>{
    frame.operate.list().then(data => {
        initTable(data)
    })
}
const leaTaskInit = () =>{
    $('#main').html(main)
    initTableByBack()
    initConfirm()
    initInsert()
}
export default leaTaskInit
