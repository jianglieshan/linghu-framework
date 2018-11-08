package linghu.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@Controller
public class AppErrorController implements ErrorController {
    private static final  String ERROR_PATH = "/error";
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private ErrorAttributes errorAttributes;

    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    /**
     * error page handler
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        int status = response.getStatus();
        switch (status){
            case 404:{
                return "404";
            }
            default:{
                return "default";
            }
        }
    }

    /**
     * error api handler
     */
//    @RequestMapping(value = ERROR_PATH)
//    @ResponseBody
//    public String errorApiHandler(HttpServletRequest request){
//        RequestAttributes requestAttribute = new ServletRequestAttributes(request);
//
//        Map<String,Object>attr = this.errorAttributes.getErrorAttributes(requestAttribute,false);
//
//    }
}
