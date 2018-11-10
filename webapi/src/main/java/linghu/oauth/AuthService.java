package linghu.oauth;

import linghu.base.ServiceContext;
import linghu.userservice.dto.LoginRequest;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;

public interface AuthService {
    UserViewModel register(RegisterRequest request, ServiceContext context);
    UserViewModel login(LoginRequest request, ServiceContext context);
    String refresh(String oldToken);
}
