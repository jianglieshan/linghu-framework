package linghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String loginRequest(){
        return "admin/center";
    }


    @GetMapping("/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/center")
    public String centerPage(){
        return "admin/center";
    }

}
