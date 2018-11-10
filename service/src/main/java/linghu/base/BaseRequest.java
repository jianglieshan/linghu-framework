package linghu.base;

public class BaseRequest<T> extends CommonRequest{
    public T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public BaseRequest(ServiceContext clientInfo, T param) {
        super(clientInfo);
        this.param = param;
    }
    public BaseRequest(T param) {
        this.param = param;
    }
    public BaseRequest(){

    }
}

