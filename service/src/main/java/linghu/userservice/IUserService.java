package linghu.userservice;

import linghu.base.ServiceContext;
import linghu.userservice.dto.LoginResonse;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String,Object>> test();

    UserViewModel register(RegisterRequest request, ServiceContext context);
    LoginResonse login(RegisterRequest request, ServiceContext context);
    boolean logout(RegisterRequest request, ServiceContext context);
}
