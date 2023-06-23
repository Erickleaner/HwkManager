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

    <title>My JSP 'stuScore.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/echarts.min.js"></script>
  </head>

  <body>
  	<div id="main" style="width: 1700px;height: 750px;padding-top:20px;padding-left: 200px;"></div>

  </body>
  <script type="text/javascript">

//基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
		title:{
			text:"学生总分统计"
		},
	    color: ['#3398DB'],
	    tooltip: {
	        trigger: 'axis',
	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
	            type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    legend: {
	        data:['分数']
	    },
	    xAxis: [
	        {
	            type: 'category',
	            data: ${stuNameList},
	            axisTick: {
	                alignWithLabel: true
	            }
	        }
	    ],
	    yAxis: [
	        {
	        	name: '总分',
	            type: 'value'
	        }
	    ],
	    series: [
	        {
	            name: '学生成绩',
	            type: 'bar',
	            barWidth: '60%',
	            data: ${scoreGradeList}
	        }
	    ]
	};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);


</script>
</html>

