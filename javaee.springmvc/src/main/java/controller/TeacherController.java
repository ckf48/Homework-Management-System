package controller;

import jdbc.HomeworkJdbc;
import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.StudentHomework;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @RequestMapping("/selectStudentHomework")
    public String selectAll(HttpServletRequest req){
        List<StudentHomework> list = StudentHomeworkJdbc.selectAllStudentHomework();
        req.setAttribute("list",list);
        return "/jsp/teacher.jsp";
    }

    @RequestMapping("/addHomework")
    public String addHomework(HttpServletRequest req){
        Homework homework = new Homework();
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        homework.setCreateTime(Timestamp.valueOf(req.getParameter("create_time")));
        homework.setUpdateTime(Timestamp.valueOf(req.getParameter("update_time")));
        HomeworkJdbc.addHomework(homework);
        return "/teacher/selectStudentHomework";
    }
}
