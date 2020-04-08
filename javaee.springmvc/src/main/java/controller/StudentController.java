package controller;

import Bean.HomeworkJdbc;
import Bean.StudentHomeworkJdbc;
import model.Homework;
import model.StudentHomework;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HomeworkJdbc.class);
        HomeworkJdbc service = (HomeworkJdbc) context.getBean("homeworkJdbc");
        List<Homework> list = service.selectAllHomework();
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

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentHomeworkJdbc.class);
        StudentHomeworkJdbc service = (StudentHomeworkJdbc) context.getBean("studentHomeworkJdbc");
        service.addStudentHomework(studentHomework);

        return "/student/selectHomework";
    }
}
