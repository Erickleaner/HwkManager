import './main.css'
import main from './main.html'
import 'bootstrap-table/dist/bootstrap-table.css'
import 'bootstrap-table/dist/bootstrap-table'
import {groupList} from "../../../../mockApi/group";
import team from "./team.html";
import item from "./item.html";
import {studentByNo} from "../../../../api/student";
import {dateStr, dutyStr} from "../../../../utils/string";
import {teamInsert, teamList, teamRemove, teamUpdate} from "../../../../api/team";
import {hmkSave, hmkSubmit} from "../../../../api/hmk";
import norHmkInit from "../nor_hmk";

const frame = {
    idField:'teamId',
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
                    isUpdate(row)
                },
                'click .operate-delete': function (e, value, row, index) {
                    e.preventDefault()
                    isDelete(row)
                }
            }
        },
    ],
}

let global = {
    hmk:null
}
const initGlobal = (obj) =>{
    //row of homework
    const {row} = obj
    global.hmk = row
}

const makeRow = ({leader,members,teamId}) =>{
    return {
        teamId,
        leaderName:leader.name,
        leaderNo:leader.no,
        groupNum:members.length+1
    }
}
const validInsert = ({leader,members}) =>{
    let msg;
    if (leader===null){
        msg = '小组一定要选择一个组长'
        return {
            valid:false,
            msg
        }
    }
    if (members.length===0){
        msg = '小组成员数量必须大于0'
        return {
            valid:false,
            msg
        }
    }
    return {valid: true}
}
const hmkData = () =>{
    const hwk = global.hmk
    return {
        homeworkId: hwk.homeworkId,
        name: $("[name='hmkName']").val(),
        detail: $("[name='hmkDetail']").val(),
        startTime: $("[name='hmkStartTime']").val(),
        endTime: $("[name='hmkEndTime']").val(),
    }
}
const initConfirm = () => {
    $('#confirm').click(function() {
        const operate = $(this).data('operate');
        if (operate===Operate.INSERT){
            const validRes = validInsert(currentRow);
            if (!validRes.valid){
                alert(validRes.msg)
                return
            }
            const {leader,members} = currentRow
            const hmk = global.hmk;
            teamInsert({leader,members,hmk}).then(data=>{
                if (data.insert){
                    alert('添加成功！')
                    const teamId = data.insertId
                    const row = makeRow({leader, members, teamId})
                    $('#table_server').bootstrapTable('append', row);
                    $('#myModal').modal('hide')
                }else {
                    alert('添加小组有误，不符合添加要求！')
                }
            })
        }
        if (operate===Operate.SAVE){
            const newData = hmkData()
            hmkSave(newData).then(data=>{
                if (data) alert('保存成功！')
                else alert('保存失败！')
                $('#myModal').modal('hide')
            })
        }
        if (operate===Operate.UPDATE){
            const row = $(this).data('row');
            const validRes = validInsert(currentRow);
            if (!validRes.valid){
                alert(validRes.msg)
                return
            }
            const {leader,members} = currentRow
            const hmk = global.hmk;
            const teamId = row.teamId
            teamUpdate({leader,members,teamId,hmk}).then(data=>{
                if (data){
                    row.teamRowVo = currentRow
                    alert('更新成功！')
                    $('#table_server').bootstrapTable('updateByUniqueId', {
                        [frame.idField]: row[frame.idField],
                        row: row
                    });
                    $('#myModal').modal('hide')
                }else {
                    alert('添加小组有误，不符合添加要求！')
                }
            })
        }
        if (operate===Operate.REMOVE){
            const row = $(this).data('row');
            const teamId = row.teamId
            teamRemove({teamId}).then(data=>{
                if (data) {
                    alert('删除成功！')
                    $('#table_server').bootstrapTable('remove', {
                        field: frame.idField,
                        values: [teamId]
                    });
                }else {
                    alert('删除失败！')
                }
                $('#myModal').modal('hide')
            })
        }
        if (operate===Operate.SUBMIT){
            const newData = hmkData()
            hmkSave(newData).then(data=>{
                if (!data) {
                    alert('保存失败,不可提交！')
                }else {
                    const hmk = global.hmk
                    const homeworkId = hmk.homeworkId
                    hmkSubmit({homeworkId}).then(data=>{
                        if (data){
                            alert('提交成功！')
                            norHmkInit()
                        }else{
                            alert('提交要求班级全员均组队！')
                        }
                    })
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
const Operate = {
    INSERT:'INSERT',
    SAVE:'SAVE',
    UPDATE:'UPDATE',
    REMOVE:'DELETE',
    SUBMIT:'SUBMIT',
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
const cloneRow = (row) =>{
    const leader = row.leader
    const members = row.members
    return {leader,members:[...members]}
}
const isUpdate = (row) =>{
    $('#myModalLabel').text('更新分组')
    $(".modal-body").html(team)
    initInsetEvent()
    const teamRow = cloneRow(row.teamRowVo)
    currentRow = teamRow
    renderTable()
    $('#confirm').data('operate',Operate.UPDATE).data('row',row);
    $('#myModal').modal('show')
}
const isDelete = (row) =>{
    $('#myModalLabel').text('删除分组')
    $(".modal-body").html('是否确认删除分组')
    $('#confirm').data('operate',Operate.REMOVE).data('row',row);
    $('#myModal').modal('show')
}
const isInsert = () =>{
    $('#myModalLabel').text('添加分组')
    $(".modal-body").html(team)
    initInsetEvent()
    const row = emptyRow();
    currentRow = row
    $('#confirm').data('operate',Operate.INSERT).data('row',row)
    $('#myModal').modal('show')
}
const isSubmit = () =>{
    $('#myModalLabel').text('提交分组')
    $(".modal-body").html('是否确认提交分组？')
    $('#confirm').data('operate',Operate.SUBMIT)
    $('#myModal').modal('show')
}
const isSave = () =>{
    $('#myModalLabel').text('保存')
    $(".modal-body").html('是否确认保存？')
    $('#confirm').data('operate',Operate.SAVE)
    $('#myModal').modal('show')
}
const initSave = () =>{
    $('#save').click(()=>{
        isSave()
    })
}
const initSubmit = () =>{
    $('#submit').click(()=>{
        isSubmit()
    })
}
const initInsert = () =>{
    $('#insertElem').click(()=>{
        isInsert()
    })
}
const initTableByBack = () =>{
    const hmk = global.hmk
    const homeworkId = hmk.homeworkId;
    teamList({homeworkId}).then(data=>{
        initTable(data)
    })
}
const initUI = ({course,clazz,row}) => {
    $("[name='courseName']").val(course.name)
    $("[name='clazzName']").val(clazz.name)
    $("[name='hmkName']").val(row.name)
    $("[name='hmkDetail']").val(row.detail)
    $("[name='hmkStartTime']").val(dateStr(row.startTime));
    $("[name='hmkEndTime']").val(dateStr(row.endTime));
}
const norTeamInit = (obj) =>{
    if (obj===null){
        alert('请点击分组添加进入')
        return
    }
    $('#main').html(main)
    initUI(obj)
    initGlobal(obj)
    initTableByBack()
    initConfirm()
    initInsert()
    initSave()
    initSubmit()
}
export default norTeamInit
