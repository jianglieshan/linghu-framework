package linghu.oauth;

import linghu.base.ServiceContext;
import linghu.userservice.IUserService;
import linghu.userservice.dto.LoginRequest;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    //@Value("${jwt.tokenHead}")
    //private String tokenHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public UserViewModel register(RegisterRequest request, ServiceContext context) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = request.password;
        request.password = encoder.encode(rawPassword);
        return userService.register(request,context);
    }

    @Override
    public UserViewModel login(LoginRequest request, ServiceContext context) {

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(request.getUserName(),
                request.getPassword());
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserViewModel uvm = userService.findUserByUsername(request.getUserName());
        UserDetails userDetails = JwtUserFactory.create(uvm);
        //userDetailsService.loadUserByUsername(request.getUserName());
        uvm.setToken(jwtTokenUtil.generateToken(userDetails));
        return uvm;
    }


    @Override
    public String refresh(String oldToken) {
        String username = jwtTokenUtil.getUsernameFromToken(oldToken);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(oldToken, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(oldToken);
        }
        return null;
    }
}