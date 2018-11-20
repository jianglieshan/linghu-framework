package linghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        //LogUtils.getBussinessLogger().error("test");
        return "index";
    }

    @PostMapping("test")
    public String test(){
        return "index";
    }
}
