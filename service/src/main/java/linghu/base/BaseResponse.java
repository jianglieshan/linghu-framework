package linghu.base;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

//@ApiModel(value = "返回类")
public class BaseResponse<T> {
//    @ApiModelProperty(value = "泛型对象，返回结果")
    public T result;
//    @ApiModelProperty(value = "描述信息")
    public String message;
//    @ApiModelProperty(value = "错误码")
    public int errorCode;

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

    public BaseResponse(T result, String message, int errorCode) {
        this.result = result;
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseResponse(T result, ErrorCode code) {
        this.result = result;
        this.message = code.getMessage();
        this.errorCode = code.getCode();
    }
}
