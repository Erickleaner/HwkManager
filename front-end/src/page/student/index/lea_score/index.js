import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/src/locale/bootstrap-table-zh-CN'
import {leaTaskList} from "../../../../mockApi/leaTask";
import {memTaskList} from "../../../../mockApi/memTask";
import memTaskInit from "../mem_task";
import {leaScoreList} from "../../../../mockApi/leaScore";
import edit from './edit.html'

const frame = {
    idField:'taskId',
    operate:{
        list:leaScoreList,
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
            title: '姓名',
            field: 'name',
            align: 'center'
        },
        {
            title: '任务名',
            field: 'taskName',
            align: 'center'
        },

        {
            title: '分数',
            field: 'score',
            align: 'center'
        },

        {
            title: '评分状态',
            field: 'scoreState',
            align: 'center',
            formatter: function(value) {
                if (value===0) return'未评分'
                if (value===1) return'已评分'
            }
        },
        {
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-score">评分</a>';
            },
            events: {
                'click .operate-score': function (e, value, row, index) {
                    e.preventDefault()
                   isUpdate(row)

                },
            }
        }
    ],
}

const Operate = {
    UPDATE:'UPDATE',
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
    $('#myModalLabel').text('考核评分')
    $(".modal-body").html(edit)
    initEdit(row);
    $('#confirm').data('operate',Operate.UPDATE).data('row',row);
    $('#myModal').modal('show')

}
const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
        if (operate===Operate.UPDATE){
            bindEdit(row)
            $('#myModal').modal('hide')
            row.scoreState = 1
            $('#table_server').bootstrapTable('updateByUniqueId', {
                [frame.idField]: row[frame.idField],
                row: row
            });
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
const leaScoreInit = () =>{
    $('#main').html(main)
    initTableByBack()
    initConfirm()
    initInsert()
}
export default leaScoreInit
