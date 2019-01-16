package linghu.controller;

import linghu.base.BaseResponse;
import linghu.base.ErrorCode;
import linghu.exceptionservice.ServiceException;
import linghu.utils.LogUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
//    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResponse<String> errorHandler(Exception ex) {
        LogUtils.getExceptionLogger().error("异常",ex);
        return new BaseResponse<>(ex.toString(),ErrorCode.FAILURE);
    }

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public BaseResponse<String> errorHandler(ServiceException ex) {
        return  new BaseResponse<>(ex.getFriendlyErrorMsg(),ErrorCode.FAILURE);
    }

    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public BaseResponse<String> errorHandler(AuthenticationException ex) {
        String msg = "认证失败";
        if(ex instanceof BadCredentialsException){
            msg = "密码错误";
        }
        else if(ex instanceof UsernameNotFoundException){
            msg = "用户不存在";
        }
        else if(ex instanceof InternalAuthenticationServiceException){
            msg = ex.getMessage();
        }
        return  new BaseResponse<>(msg,ErrorCode.FAILURE);
    }

    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public BaseResponse<String> errorHandler(AccessDeniedException ex) {
        String msg = "权限不足";
        return  new BaseResponse<>(msg,ErrorCode.FAILURE);
    }
}
