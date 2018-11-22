package linghu.oauth;


import linghu.userservice.IUserService;
import linghu.userservice.dto.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserViewModel user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("'%s'不存在", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}