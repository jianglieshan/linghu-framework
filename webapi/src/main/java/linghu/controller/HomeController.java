package linghu.controller;

import linghu.userservice.IUserService;
import linghu.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String index()
    {
        LogUtils.getBusinessLogger().error("测试一下啊啊啊啊啊啊啊");
        return "hello";
    }

    @GetMapping("/test")
    public List<Map<String,Object>> test()
    {
        return userService.test();
    }

    @GetMapping("/private")
    public String privateArea()
    {
        return "private";
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public Principal admin(Principal user) {
        return user;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Principal user(Principal user) {
        return user;
    }
}
