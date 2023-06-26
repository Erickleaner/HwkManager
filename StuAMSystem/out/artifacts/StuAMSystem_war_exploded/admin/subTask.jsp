<%--
  Created by IntelliJ IDEA.
  User: tx
  Date: 2023-06-24
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


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
    .div_ads {
      width: 75%;
      margin: 0 auto;
      margin-top: 50px;
      margin-left: 10%;
    }

    table {
      margin: 0 auto;
      width:100%;
      border-collapse:separate;
      border-spacing:0px 10px;
    }
    table tr td {
      text-align: center;
      width:30%;
      height:44px;
      color:rgba(0,0,0,.6)
    }
    ._td{
      width:30%
    }
    font{
      color:red;
      font-weight: bold;
    }
  </style>

  <script type="text/javascript">

  </script>

</head>

<body>


  <div class="div_ads">
    <table>
      <tr>
        <td>所属任务：</td>
        <td><input type="text" name="hostTask" class="form-control"  readonly="readonly" /></td>
      </tr>
      <tr>
        <td>分&nbsp;任&nbsp;务：</td>
        <td><input type="text" name="partTask" class="form-control" value="${list.getCourseName() }"  readonly="readonly" /></td>
      </tr>/></td>
      </tr>
      <tr>
        <td>分&nbsp;&nbsp;&nbsp;数：</td>
        <td><input type="text"  name="taskCredit" class="form-control" value="${list.getCourseCredit() }" readonly="readonly" /></td>
      </tr> />

      </td>
      </tr>
      <tr>
        <td>要求时间/天：</td>
        <td><input type="text" name="taskHours" class="form-control" value="${list.getCourseHours() }" readonly="readonly" /></td>
      </tr>/></td>
      </tr>
      <tr>
        <td>开始时间：</td>
        <td><input type="text" name="taskDate" class="form-control" value="${list.getCourseDate() }" readonly="readonly" /></td>
      </tr>/></td>
      </tr>
      <tr>
        <td>任务详细：</td>
        <td><textarea type="text" name="taskDetail" rows="10" cols="50"
                      class="form-control" value="${list.getCourseDate() }" readonly="readonly" >这里是从数据库拿到的任务详细
				</textarea></td>
      </tr>

      <tr>
        <td><input type="submit" value="确认添加" class="btn btn-primary" /></td>
<%--        <--%>
      </tr>
    </table>
  </div>
</form>

</body>
</html>
