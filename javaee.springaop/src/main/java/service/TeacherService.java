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
@Component
public class TeacherService {
    private HomeworkJdbc homeworkJdbc;
    private StudentHomeworkJdbc studentHomeworkJdbc;

    @Autowired
    public TeacherService(HomeworkJdbc homeworkJdbc, StudentHomeworkJdbc studentHomeworkJdbc) {
        this.homeworkJdbc = homeworkJdbc;
        this.studentHomeworkJdbc = studentHomeworkJdbc;
    }

    public String selectAllStudentHomework(HttpServletRequest req) {
        List<StudentHomework> list = studentHomeworkJdbc.selectAllStudentHomework();
        req.setAttribute("list", list);
        return "/jsp/teacher.jsp";
    }

    public String addHomework(HttpServletRequest req) {
        Homework homework = new Homework();
        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        homework.setCreateTime(Timestamp.valueOf(req.getParameter("create_time")));
        homework.setUpdateTime(Timestamp.valueOf(req.getParameter("update_time")));
        homeworkJdbc.addHomework(homework);
        return "/teacher/selectStudentHomework";
    }
}
