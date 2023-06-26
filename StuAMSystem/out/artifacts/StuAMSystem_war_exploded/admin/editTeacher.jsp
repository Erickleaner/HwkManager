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
</style>
</head>

<body>
	<form action="ServletEditTea" method="post">
	
		<div class="div_ads">
		<font>${msg }</font>
		<c:forEach var="list" items="${list }">
			<table>

				<tr>
					<td>代码：</td>
					<td><textarea type="text" name="major" class="form-control" rows="20" cols="50" value="${list.getMajor() }" ></textarea></td>
				</tr>

			</table>
			</c:forEach>
		</div>
	</form>
</body>
</html>