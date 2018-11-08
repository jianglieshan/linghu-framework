package linghu.controller;

import linghu.utils.LogUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index()
    {
        LogUtils.getBusinessLogger().error("error");
        return "hello";
    }

    @GetMapping("/private")
    public String privateArea()
    {
        return "private";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/user")
    public Principal user(Principal user) {

        return user;
    }
}
