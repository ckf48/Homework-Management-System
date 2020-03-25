<%@ page import="model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/11
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">
        <tr align="center" bgcolor="#7fffd4" height="50">
            <td>ID</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td>更新时间</td>
        </tr>
        <%
            List<Homework> list = (List<Homework>) request.getAttribute("list");
            if (list.size() <= 0) {
                out.print("None data");
            } else {
                for (Homework homework : list) {
        %>
        <tr align="center" bgcolor="white" height="30">
            <td><%=homework.getId()%>
            </td>
            <td><%=homework.getTitle()%>
            </td>
            <td><%=homework.getContent()%>
            </td>
            <td><%=homework.getCreateTime()%>
            </td>
            <td><%=homework.getUpdateTime()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
<div align="center">
    <form  action="${pageContext.request.contextPath}/addStudentHomework" method="get">
        <label>
            学生号：<input type="number" name="student_id">
        </label><br/>
        <label>
            作业号：<input type="number" name="homework_id">
        </label><br>
        <label>
            作业题目：<input type="text" name="homework_title">
        </label><br/>
        <label>
            作业内容：<input type="text" name="homework_content">
        </label><br/>
        <label>
            上传时间：<input type="text" name="create_time">
        </label><br/>
        <label>
            修改时间：<input type="text" name="update_time">
        </label><br/>
        <input type="submit" value="发布">
    </form>
</div>
</body>
</html>
