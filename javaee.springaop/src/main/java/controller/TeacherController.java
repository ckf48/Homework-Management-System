package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TeacherService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ckf48
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @RequestMapping("/selectStudentHomework")
    public String selectAllStudentHomework(HttpServletRequest req){
        return teacherService.selectAllStudentHomework(req);
    }

    @RequestMapping("/addHomework")
    public String addHomework(HttpServletRequest req){
        return teacherService.addHomework(req);
    }
}
