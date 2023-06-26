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
    
    <title>My JSP 'editCourse.jsp' starting page</title>
    
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
.div_ads {
	width: 75%;
	margin: 0 auto;
	margin-top: 50px;
	margin-left: 10%;
}
table {
	margin: 0 auto;
	width: 100%
}

table tr td {
	text-align: center;
	width:50%;
	height:50px;
}
</style>
</head>

<body>
	<form action="ServletEditCos" method="post">
	
		<div class="div_ads">
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>编&nbsp;&nbsp;&nbsp;号：</td>
					<td><input type="text" name="courseID" class="form-control" value="${list.getCourseID() }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>任&nbsp;&nbsp;&nbsp;务：</td>
					<td><input type="text" name="courseName" class="form-control" value="${list.getCourseName() }"  readonly="readonly" /></td>
				</tr>/></td>
				</tr>
				<tr>
					<td>分&nbsp;&nbsp;&nbsp;数：</td>
					<td><input type="text"  name="courseCredit" class="form-control" value="${list.getCourseCredit() }" readonly="readonly" /></td>
				</tr> />
						
					</td>
				</tr>
				<tr>
					<td>要求时间/天：</td>
					<td><input type="text" name="courseHours" class="form-control" value="${list.getCourseHours() }" readonly="readonly" /></td>
				</tr>/></td>
				</tr>
				<tr>
					<td>开始时间：</td>
					<td><input type="text" name="courseDate" class="form-control" value="${list.getCourseDate() }" readonly="readonly" /></td>
				</tr>/></td>
				</tr>
				<tr>
					<td>任务详细：</td>
					<td><textarea type="text" name="courseTea" rows="10" cols="50"
								  class="form-control" value="${list.getCourseDate() }" readonly="readonly" >这里是从数据库拿到的任务详细
				</textarea></td>
				</tr>

				<tr>
					<td><form action="admin/viewTask.jsp" method="GET">
						<button type="submit">分解任务</button>
					</form></td>

<%--					<td><input type="submit" value="修改" class="btn btn-primary" /></td>--%>
<%--					<td><input type="reset" value="清空" class="btn btn-danger" /></td>--%>
				</tr>
			</table>
			</c:forEach>
		</div>
	</form>
</body>
</html>
