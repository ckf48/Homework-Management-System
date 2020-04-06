package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/test")
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "/index.jsp";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "/jsp/index.jsp";
    }

    @RequestMapping("/test3")
    public void test3(@RequestParam(required = false) String account, String pwd) {
        System.out.println(account);
        System.out.println(pwd);

    }

}
