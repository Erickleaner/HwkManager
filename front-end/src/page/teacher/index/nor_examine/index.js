import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import {teamList} from "../../../../mockApi/team";
import edit from "./edit.html";


const frame = {
    idField:'teamId',
    operate:{
        list:teamList,
    },
    columns: [
/*        {
            title: '组号',
            field: 'teamId',
            align: 'center'
        },*/
        {
            title: '姓名',
            field: 'name',
            align: 'center'
        },
        {
            title: '学号',
            field: 'no',
            align: 'center'
        },
        {
            title: '成绩',
            field: 'grade',
            align: 'center'
        },
        {
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-detail mr-15">查看提交</a>' +
                    '<a href="#" class="operate-examine" >修改评分</a>';
            },
            events: {
                'click .operate-detail': function (e, value, row, index) {
                    e.preventDefault()

                },
                'click .operate-examine': function (e, value, row, index) {
                    e.preventDefault()
                    updateGrade(row)
                }
            }
        },
    ],
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
const updateGrade = (row) =>{
    $('#myModalLabel').text('修改评分')
    $(".modal-body").html(edit)
    initEdit(row)
    $('#confirm').data('operate',Operate.UPDATE_GRADE).data('row',row);
    $('#myModal').modal('show')
}
const Operate = {
    REMOVE:'REMOVE',
    'UPDATE_GRADE':'UPDATE_GRADE'
}

const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
        if (operate === Operate.UPDATE_GRADE){
            bindEdit(row)
            $('#myModal').modal('hide')
            $('#table_server').bootstrapTable('updateByUniqueId', {
                [frame.idField]: row[frame.idField],
                row: row
            });
            alert('更新成功！')
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
const isInsert = () =>{
    $('#myModalLabel').text('添加数据')
    $(".modal-body").html(edit)
    //$('#confirm').data('operate',Operate.INSERT).data('row',row);
    $('#myModal').modal('show')
}
const initInsert = () =>{
    $('#insertElem').click(()=>{
        isInsert()
    })
}
const initTableByBack = () =>{
    frame.operate.list().then(data => {
        initTable(data)
    })
}
const norGradeInit = () =>{
    $('#main').html(main)
    initTableByBack()
    initConfirm()
    initInsert()
}
export default norGradeInit
