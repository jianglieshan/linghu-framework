package linghu.base;

public class CommonRequest {

    private ServiceContext clientInfo;

    public ServiceContext getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ServiceContext clientInfo) {
        this.clientInfo = clientInfo;
    }

    public CommonRequest(ServiceContext clientInfo) {
        this.clientInfo = clientInfo;
    }

    public CommonRequest(){

    }

}

