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

<title>My JSP 'addStudent.jsp' starting page</title>

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
font{
	color:red;
	font-weight: bold;
}
</style>
</head>

<body>
	<form action="ServletEditStu" method="post">
	
		<div class="div_ads">
		<c:forEach var="list" items="${list }">
			<table>
				<tr>
					<td>文档名：</td>
					<td><input type="text" name="document" class="form-control" value="${list.getStuNum() }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>文档详细：</td>
					<td><textarea type="text" name="documentDetail" class="form-control" rows="20" cols="50" value="${list.getMajor() }" ></textarea></td>
				</tr>
			</table>
			</c:forEach>
		</div>
	</form>
</body>
</html>

