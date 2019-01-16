package linghu.busness;

import linghu.base.BaseActionRequest;
import linghu.base.BaseViewModel;
import linghu.base.ICrudService;
import linghu.exceptionservice.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImpl implements IBusinessService {

//    @Autowired
//    @Qualifier(value = "crudServiceMap")
    private Map<String,ICrudService> serviceMap;

//    @Autowired
//    @Qualifier(value = "actionMap")
    private Map<String,String> actionMap;

    @Override
    public BaseViewModel addOrUpdate(BaseActionRequest request) {
        BaseViewModel res;
        ICrudService service = serviceMap.get(request.getClassName());
        try {
            String methodName = actionMap.get(request.getClassName()+"-"+request.getAction());
            if(methodName == null){
                methodName = request.getAction();
            }
            Method method = service.getClass().getMethod(methodName,BaseActionRequest.class);
            res = (BaseViewModel)method.invoke(service,request);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
            if(e instanceof InvocationTargetException){
                throw ServiceException.createException(((InvocationTargetException) e).getTargetException().getMessage());
            }
            throw ServiceException.createException("方法不存在");
        }
        return res;
    }

    @Override
    public List<BaseViewModel> query(BaseActionRequest request) {
        List<BaseViewModel> res;
        ICrudService service = serviceMap.get(request.getClassName());
        try {
            String methodName = actionMap.get(request.getClassName()+"-"+request.getAction());
            if(methodName == null){
                methodName = request.getAction();
            }
            Method method = service.getClass().getMethod(methodName,BaseActionRequest.class);
            res = (List<BaseViewModel>)method.invoke(service,request);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
            if(e instanceof InvocationTargetException){
                throw ServiceException.createException(((InvocationTargetException) e).getTargetException().getMessage());
            }
            throw ServiceException.createException("方法不存在");
        }
        return res;
    }
}
