package linghu.base;

public class ServiceContext{
    public String currentUserId;
    public String token;
    public String device;
    public String userName;
    public String role;

    public ServiceContext(String currentUserId, String token, String device) {
        this.currentUserId = currentUserId;
        this.token = token;
        this.device = device;
    }

    public ServiceContext() {
    }
}
