package service;

import model.Homework;
import model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import util.HomeworkJdbc;
import util.StudentHomeworkJdbc;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author ckf48
 */

@Service
public class StudentService {
    private StudentHomeworkJdbc studentHomeworkJdbc;
    private HomeworkJdbc homeworkJdbc;

    @Autowired
    public StudentService(StudentHomeworkJdbc studentHomeworkJdbc, HomeworkJdbc homeworkJdbc) {
        this.homeworkJdbc = homeworkJdbc;
        this.studentHomeworkJdbc = studentHomeworkJdbc;
    }

    public String selectAllHomework(HttpServletRequest req) {
        List<Homework> list = homeworkJdbc.selectAllHomework();
        req.setAttribute("list", list);
        return "/jsp/student.jsp";
    }

    public String addStudentHomework(HttpServletRequest req) {
        StudentHomework studentHomework = new StudentHomework();
        Long studentId = Long.valueOf(req.getParameter("student_id"));
        Long homeworkId = Long.valueOf(req.getParameter("homework_id"));
        studentHomework.setStudentId(studentId);
        studentHomework.setHomeworkId(homeworkId);
        studentHomework.setHomeworkTitle(req.getParameter("homework_title"));
        studentHomework.setHomeworkContent(req.getParameter("homework_content"));
        studentHomework.setCreateTime(Timestamp.valueOf(req.getParameter("create_time")));
        studentHomework.setUpdateTime(Timestamp.valueOf(req.getParameter("update_time")));
        studentHomeworkJdbc.addStudentHomework(studentHomework);
        return "/student/selectHomework";
    }


}
