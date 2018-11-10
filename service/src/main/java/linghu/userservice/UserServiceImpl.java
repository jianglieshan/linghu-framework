package linghu.userservice;

import linghu.base.ServiceContext;
import linghu.base.UserRole;
import linghu.entity.User;
import linghu.exceptionservice.ServiceException;
import linghu.repository.IUserRepository;
import linghu.userservice.dto.LoginResonse;
import linghu.userservice.dto.RegisterRequest;
import linghu.userservice.dto.UserViewModel;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    EntityManager manager;
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<Map<String,Object>> test() {
        String sql = "select * from user";
        Query query = manager.createNativeQuery(sql);
        List<Map<String, Object>> resultList = query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        if(CollectionUtils.isEmpty(resultList)) {
            return null;
        }
//        List<BookExpress> result = new ArrayList<>(resultList.size());
//        for(Map<String,Object> map : resultList) {
//            BookExpress exp = new BookExpress();
//            BeanUtils.populate(exp, map);
//            result.add(exp);
//        }
        return resultList;
    }

    @Override
    public UserViewModel register(RegisterRequest request, ServiceContext context) {
        User u = userRepository.findByuserName(request.userName);
        if(u != null){
            throw  ServiceException.createException("用户名已存在");
        }
        u = new User();
        u.setPwd(request.password);
        u.setUserName(request.userName);
        u.setCreateDate(new Date());
        u.setRoles(UserRole.USER);
        return new UserViewModel(userRepository.save(u));
    }

    @Override
    public LoginResonse login(RegisterRequest request, ServiceContext context) {
        return null;
    }

    @Override
    public boolean logout(RegisterRequest request, ServiceContext context) {
        return false;
    }

    @Override
    public UserViewModel findUserByUsername(String userName) {
        User u = userRepository.findByuserName(userName);
        if(u == null){
            throw ServiceException.createException("用户不存在");
        }
        return new UserViewModel(u);
    }
}
