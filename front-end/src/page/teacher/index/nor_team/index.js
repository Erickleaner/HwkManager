import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import {groupList} from "../../../../mockApi/group";
import team from "./team.html";
import item from "./item.html";
import {studentByNo} from "../../../../api/student";
import {dutyStr} from "../../../../utils/string";


const frame = {
    idField:'groupId',
    operate:{
        list:groupList,
    },
    columns: [
        {
            title: '组号',
            align: 'center',
            formatter: function(value, row, index) {
                return index + 1;
            }
        },
        {
            title: '组长名',
            field: 'leaderName',
            align: 'center'
        },
        {
            title: '组长学号',
            field: 'leaderNo',
            align: 'center'
        },
        {
            title: '组员数',
            field: 'groupNum',
            align: 'center'
        },
        {
            title: '操作',
            align: 'center',
            formatter: function () {
                return '<a href="#" class="operate-update mr-15">修改</a>' +
                    '<a href="#" class="operate-delete" >删除</a>';
            },
            events: {
                'click .operate-update': function (e, value, row, index) {
                    e.preventDefault()
                },
                'click .operate-delete': function (e, value, row, index) {
                    e.preventDefault()
                }
            }
        },
    ],
}


const validTeam = () =>{
    //valid -> data
    //else -> nul
    const {leader,members} = currentRow
    if (leader!=null&&members.length>0){

    }else return null;
}
const bindTeam = (row) =>{
/*    const leader = {
        no:$('#')
    }*/
}
const initConfirm = () => {
    $('#confirm').click(function() {
        let row = $(this).data('row');
        const operate = $(this).data('operate');
        if (operate===Operate.INSERT){
            bindTeam(row)
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
const Operate = {
    INSERT:'INSERT',
}
let currentRow = null;
const emptyRow = () =>{
    return{
        leader:null,
        members:[]
    }
}
const appendLeader = (member) =>{
    let element = $('<tr>').html(item);
    element.find('[name="no"]').text(member.no)
    element.find('[name="name"]').text(member.name)
    element.find('[name="duty"]').text(dutyStr('leader'))
    element.find('[name="remove"]').click(()=>{
        currentRow.leader = null;
        renderTable()
    })
    $("[name='members']").append(element)
}
const appendMember = (member) =>{
    let element = $('<tr>').html(item);
    element.find('[name="no"]').text(member.no)
    element.find('[name="name"]').text(member.name)
    element.find('[name="duty"]').text(dutyStr('member'))
    element.find('[name="remove"]').on('click', function() {
        let {members} = currentRow
        const index = members.indexOf(member);
        if (index !== -1) {
            members.splice(index, 1);
        }
        renderTable()
    });
    $("[name='members']").append(element)
}
//根据currentRow进行render
const renderTable = () =>{
    $("[name='members']").html('')
    const {leader,members} = currentRow
    if (leader!==null){
        appendLeader(leader,'leader')
    }
    members.forEach(member=>{
        appendMember(member,'member')
    })
}
const validUnique = (student) =>{
    const {leader,members} = currentRow
    let isUnique = true;
    if (leader!=null){
        if (leader.no === student.no) {
            isUnique = false;
            return isUnique
        }
    }
    members.forEach(member=>{
        if (member.no === student.no) {
            isUnique = false
        }
    })
    return isUnique
}
const initInsetEvent = () =>{
    $('[name="leaderSubmit"]').click(()=>{
        const {leader} = currentRow
        if (leader!=null){
            alert('组长只能有一个！')
            return
        }
        const no = $('[name="leaderNo"]').val()
        studentByNo({no}).then(student=>{
            if (student===null){
                alert('学号不存在')
                return
            }
            if (!validUnique(student)){
                alert('组内人员不能重复添加')
                return
            }
            currentRow.leader = {
                no:student.no,
                name:student.name
            }
            renderTable()
        })

    })
    $('[name="memberSubmit"]').click(()=>{
        const no = $('[name="memberNo"]').val()
        studentByNo({no}).then(student=>{
            if (student===null){
                alert('学号不存在')
                return
            }
            if (!validUnique(student)){
                alert('组内人员不能重复添加')
                return
            }
            const member = {
                no:student.no,
                name:student.name
            }
            currentRow.members.push(member)
            renderTable()
        })
    })
}
const isInsert = () =>{
    $('#myModalLabel').text('添加分组')
    $(".modal-body").html(team)
    initInsetEvent()
    const row = emptyRow();
    currentRow = row
    $('#confirm').data('operate',Operate.INSERT).data('row',row);
    $('#myModal').modal('show')
}
const initInsert = () =>{
    $('#insertElem').click(()=>{
        isInsert()
    })
}
const initTableByEmpty = () =>{
    initTable([])
}
const initUI = ({course,clazz}) => {
    $("[name='courseName']").val(course.name)
    $("[name='clazzName']").val(clazz.name)
}
const norTeamInit = (obj) =>{
    if (obj===null){
        alert('请点击分组添加进入')
        return
    }
    $('#main').html(main)
    initUI(obj)
    initTableByEmpty()
    initConfirm()
    initInsert()
}
export default norTeamInit
