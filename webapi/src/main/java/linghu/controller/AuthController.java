package linghu.controller;

import linghu.base.BaseRequest;
import linghu.base.BaseResponse;
import linghu.base.ErrorCode;
import linghu.dto.JwtAuthenticationRequest;
import linghu.dto.JwtAuthenticationResponse;
import linghu.entity.User;
import linghu.oauth.AuthService;
import linghu.userservice.dto.LoginRequest;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth/")
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "${jwt.route.authentication.login}", method = RequestMethod.POST)
    public BaseResponse<UserViewModel> login(
            @RequestBody BaseRequest<LoginRequest> request) throws AuthenticationException {
        UserViewModel u = authService.login(request.param, request.clientInfo);
        return new BaseResponse<>(u,ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.POST)
    public BaseResponse<String> refresh(@RequestBody BaseRequest<String> request,HttpServletRequest servletRequest){

        String token = servletRequest.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new BaseResponse<>(refreshedToken,ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public BaseResponse<UserViewModel> register(@RequestBody BaseRequest<RegisterRequest> request) throws AuthenticationException{
        return  new BaseResponse<>(authService.register(request.param,request.clientInfo),ErrorCode.SUCCESS);
    }
}