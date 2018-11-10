package linghu.base;

public class CommonRequest {

    public ServiceContext clientInfo;

    public ServiceContext getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ServiceContext clientInfo) {
        this.clientInfo = clientInfo;
    }

    public CommonRequest(ServiceContext clientInfo) {
        this.clientInfo = clientInfo;
    }

    public CommonRequest() {
    }
}

