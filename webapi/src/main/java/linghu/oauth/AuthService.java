package linghu.oauth;

import linghu.base.ServiceContext;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;

public interface AuthService {
    UserViewModel register(RegisterRequest request, ServiceContext context);
    String login(String username, String password);
    String refresh(String oldToken);
}
