<%@ page import="java.util.List" %>
<%@ page import="model.StudentHomework" %>
<%@ page import="jdbc.StudentHomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/29
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>T</title>
</head>
<body>
<div>
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">

        <tr align="center" bgcolor="#7fffd4" height="50">
            <td>ID</td>
            <td>学生编号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td>更新时间</td>
        </tr>
        <%
            List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");
            if (list.size() <= 0) {
                out.print("None data");
            } else {
                for (StudentHomework sh : list) {
        %>
        <tr align="center" bgcolor="white" height="30">
            <td><%=sh.getId()%>
            </td>
            <td><%=sh.getStudentId()%>
            </td>
            <td><%=sh.getHomeworkId()%>
            </td>
            <td><%=sh.getHomeworkTitle()%>
            </td>
            <td><%=sh.getHomeworkContent()%>
            </td>
            <td><%=sh.getCreateTime()%>
            </td>
            <td><%=sh.getUpdateTime()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
<div align="center">
    <form action="${pageContext.request.contextPath}/addHomework" method="get">
        <label>
           作业题目： <input type="text" name="title">
        </label><br/>
        <label>
           内容： <input type="text" name="content">
        </label><br/>
        <label>
           发布时间： <input type="text" name="create_time">
        </label><br/>
        <label>
           更新时间： <input type="text" name="update_time">
        </label><br/>
        <input type="submit" value="发布">
    </form>
</div>
</body>
</html>
