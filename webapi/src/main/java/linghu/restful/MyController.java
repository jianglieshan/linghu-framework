package linghu.restful;

import linghu.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private MyService myService;

    @GetMapping("/greeting")
    public String greeting() {
        myService.hello();
        return "greeting";
    }
}
