import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import 'bootstrap-table/src/locale/bootstrap-table-zh-CN'
import {semesterStr} from "../../../../utils/string";
import {courseList} from "../../../../api/course";

import edit from './edit.html'
import {tcInsert} from "../../../../api/tc";
import {getUser} from "../../../../storage";
/*import 'bootstrap-select/dist/js/bootstrap-select.min'
import 'bootstrap-select/dist/css/bootstrap-select.min.css'*/
const Operate = {
    ACQUIRE:'ACQUIRE',
}
const aquireCourse = (row) =>{
    $('#myModalLabel').text('领课')
    $(".modal-body").html(edit)
    $('#confirm').data('operate',Operate.ACQUIRE).data('row',row);
    $('#myModal').modal('show')
}
const makeRow = (row) =>{
    const user = getUser()
    return {
        teacherId: user.teacherId,
        courseId: row.courseId
    }
}
const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
        if (operate===Operate.INSERT){
            $('#myModal').modal('hide')
            tcInsert(makeRow(row)).then((isInsert) => {
                if (isInsert){
                    alert('领课成功！')
                }else {
                    alert('领课失败！')
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
        uniqueId: 'courseId',
        columns: [
            {
                field: 'courseId',
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
                title: '课程名',
                field: 'name',
                align: 'center'
            },
            {
                title: '编号',
                field: 'serialNum',
                align: 'center'
            },
            {
                title: '学分',
                field: 'score',
                align: 'center'
            },
            {
                title: '学时',
                field: 'stuTime',
                align: 'center'
            },
            {
                title: '开课学期',
                field: 'semester',
                align: 'center',
                formatter: function(value) {
                    return semesterStr(value);
                }
            },
            {
                title: '操作',
                align: 'center',
                formatter: function () {
                    return '<a href="#" class="operate-acquire mr-15">领课</a>'
                },
                events: {
                    'click .operate-acquire': function (e, value, row, index) {
                        e.preventDefault()
                        aquireCourse(row)
                    },
                }
            }
        ],
    });
}
const initTableByBack = () =>{
    courseList().then(data => {
        initTable(data)
    })
}
const norAcquireInit = () =>{
    $('#main').html(main)
    initTableByBack()
}
export default norAcquireInit
