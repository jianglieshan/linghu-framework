package linghu.base;


public class BaseResponse<T> {
    private T result;
    private String message;
    private int errorCode;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


    public BaseResponse(T result, ErrorCode code) {
        this.result = result;
        this.message = code.getMessage();
        this.errorCode = code.getCode();
    }
}
