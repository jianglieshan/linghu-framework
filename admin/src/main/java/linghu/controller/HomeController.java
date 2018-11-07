package linghu.controller;

import linghu.utils.LogUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        LogUtils.getBussinessLogger().error("test");
        return "index";
    }
}
