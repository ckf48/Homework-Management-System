package servlet;

import jdbc.StudentHomeworkJdbc;
import model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/addStudentHomework")
public class AddStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StudentHomework studentHomework = new StudentHomework();
        //studentHomework.setId(Long.getLong(req.getParameter("id")));
        Long studentId  = Long.valueOf(req.getParameter("student_id"));
        Long homeworkId = Long.valueOf(req.getParameter("homework_id"));
        studentHomework.setStudentId(studentId);
        studentHomework.setHomeworkId(homeworkId);
        studentHomework.setHomeworkTitle(req.getParameter("homework_title"));
        studentHomework.setHomeworkContent(req.getParameter("homework_content"));
        studentHomework.setCreateTime(Timestamp.valueOf(req.getParameter("create_time")));
        studentHomework.setUpdateTime(Timestamp.valueOf(req.getParameter("update_time")));

        StudentHomeworkJdbc.addStudentHomework(studentHomework);

        resp.sendRedirect("selectHomework");
    }
}
