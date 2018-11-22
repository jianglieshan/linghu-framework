package linghu.security;

import linghu.userservice.IUserService;
import linghu.userservice.dto.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private IUserService userService;

    final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String inputPwd = authentication.getCredentials().toString();
        UserViewModel uvm = userService.findUserByUsername(userName);

        if(!encoder.matches(inputPwd,uvm.getPwd())){
            throw new BadCredentialsException("");
        }
//        return null;
        JwtUser ju = JwtUserFactory.create(uvm);
        return new UsernamePasswordAuthenticationToken(ju,null,ju.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
