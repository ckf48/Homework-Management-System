package controller;

import jdbc.HomeworkJdbc;
import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/student")
@Controller
public class StudentController {

    @RequestMapping("/selectHomework")
    public String selectAll(HttpServletRequest req){
        List<Homework> list = HomeworkJdbc.selectAllHomework();
        req.setAttribute("list",list);
        return "/jsp/student.jsp";
    }

    @RequestMapping("/addStudentHomework")
    public String addStudentHomework(HttpServletRequest req){
        StudentHomework studentHomework = new StudentHomework();
        Long studentId  = Long.valueOf(req.getParameter("student_id"));
        Long homeworkId = Long.valueOf(req.getParameter("homework_id"));
        studentHomework.setStudentId(studentId);
        studentHomework.setHomeworkId(homeworkId);
        studentHomework.setHomeworkTitle(req.getParameter("homework_title"));
        studentHomework.setHomeworkContent(req.getParameter("homework_content"));
        studentHomework.setCreateTime(Timestamp.valueOf(req.getParameter("create_time")));
        studentHomework.setUpdateTime(Timestamp.valueOf(req.getParameter("update_time")));

        StudentHomeworkJdbc.addStudentHomework(studentHomework);

        return "/student/selectHomework";
    }
}
