package linghu.userservice.dto;

import linghu.entity.User;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class UserViewModel {

    private Integer id;
    private String userName;
    private String pwd;
    private List<String> roles;
    private Date lastPasswordResetDate;
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public UserViewModel() {
    }
    public UserViewModel(User user) {
        id = user.getId();
        userName = user.getUserName();
        pwd = user.getPwd();
        roles = Arrays.asList(user.getRoles().split(","));
        lastPasswordResetDate = user.getLastPasswordResetDate();
        createDate = user.getCreateDate();
    }

}
