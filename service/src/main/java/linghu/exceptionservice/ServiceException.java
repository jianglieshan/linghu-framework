package linghu.exceptionservice;


import linghu.base.ErrorCode;

public class ServiceException extends RuntimeException {
    private ErrorCode errorCode;
    private String friendlyErrorMsg;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getFriendlyErrorMsg() {
        return friendlyErrorMsg;
    }

    public void setFriendlyErrorMsg(String friendlyErrorMsg) {
        this.friendlyErrorMsg = friendlyErrorMsg;
    }

    public ServiceException(String message){
        this(message,ErrorCode.FAILURE);
    }

    public ServiceException(String message, ErrorCode errorCode) {
        super(message);
        this.friendlyErrorMsg = message;
        this.errorCode = errorCode;
    }

    public static ServiceException createException(String msg){
        return new ServiceException(msg);
    }

    public static ServiceException createException(String msg,ErrorCode code){
        return new ServiceException(msg,code);
    }
}
