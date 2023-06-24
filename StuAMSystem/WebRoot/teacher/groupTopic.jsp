<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .div_list {
            width: 75%;
            margin: 0 auto;
            margin-top: 50px;
            margin-left: 20%;

        }

        font {
            color: red;
            font-weight: bold;
            text-align: center;
        }
        #tableClass{
            margin:0 auto;
            width: 100%

        }
        table tr td{
            text-align: center;
            width:150px;
            height:40px;
        }
        a{
            text-decoration: none;
            cursor:pointer;
        }
        .form1{
            width: 200px;
            display: inline-block
        }
    </style>
    <script type="text/javascript">

        function page(s){
            var frm=document.getElementById("frm");
            var pageNo=document.getElementById("pageNo");
            pageNo.value=s;
            frm.submit();
        }
        $(document).ready(function() {
            $("#setleader").click(function() {
                var pageTitle = $("#leader");
                if (pageTitle.text() === "否") {
                    pageTitle.text("是");
                } else {
                    pageTitle.text("是");
                }
            });
        });
    </script>
</head>

<body>
<form action="ServletGroupTopic" method="post" id="frm">
    <div class="div_list panel panel-default">
        <div class="panel-heading">分组信息</div>
        <table class="table panel-body" id="tableClass">
            <tr>
                <td>小组</td>
                <td>学生学号</td>
                <td>学生姓名</td>
                <td>所在班级</td>
                <td>是否组长</td>
                <td>操作</td>
            </tr>
            <c:forEach var="list1" items="${list.pbjs }">
                <tr>
                    <td>第${list.pageNo }组</td>
                    <td>${list1.getStuNum() }</td>
                    <td>${list1.getStuName() }</td>
                    <td>${list1.getStuClass() }</td>
                    <td id="leader">否</td>
                    <td><a >修改</a>&nbsp;<a  onclick="return confirm('是否确认删除？')">移除</a>&nbsp;&nbsp;<a id="setleader">设为组长</a></td>

                </tr>
            </c:forEach>
            <tr>
                <td colspan="7">
                    <a onclick="page(1);">首页</a>
                    <c:if test="${list.isPrevious() }">
                        <a onclick="page(${list.pageNo-1});">上一页</a>
                    </c:if>
                    <c:if test="${(list.pageNo+1)<list.totalPage }">
                        <a onclick="page(${list.pageNo+1 });">${list.pageNo+1 }</a>
                    </c:if>
                    <c:if test="${(list.pageNo+2)<list.totalPage }">
                        <a onclick="page(${list.pageNo+2 });">${list.pageNo+2 }</a>
                    </c:if>
                    <c:if test="${list.isNext() }">
                        <a onclick="page(${list.pageNo+1});">下一页</a>
                    </c:if>
                    <a onclick="page(${list.totalPage });">最后一页</a> <br />
                    跳转到：<input class="form-control form1"
                                  id="pageNo" type="text" name="pageNo" value="${list.pageNo }" />
                    每页记录数：<input type="text" name="pageCount" class="form-control form1"
                                      value="${list.pageCount }" />

                    <input class="btn btn-primary"
                           type="submit" value="跳转" /> 共有${list.totalPage }页</td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>
