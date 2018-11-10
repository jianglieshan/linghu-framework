package linghu.base;

public class BasePageResponse<T> extends BaseResponse<T> {
    public PageModel page;

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }

    public BasePageResponse(T result, String message, int errorCode, PageModel page) {
        super(result, message, errorCode);
        this.page = page;
    }

    public BasePageResponse(T result, ErrorCode code, PageModel page) {
        super(result, code);
        this.page = page;
    }
}
