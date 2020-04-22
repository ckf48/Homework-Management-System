package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ckf48
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/selectHomework")
    public String selectAllHomework(HttpServletRequest req) {
        return studentService.selectAllHomework(req);
    }

    @RequestMapping("/addStudentHomework")
    public String addStudentHomework(HttpServletRequest req) {
        return studentService.addStudentHomework(req);
    }

}
