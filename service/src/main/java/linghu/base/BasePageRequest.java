package linghu.base;

public class BasePageRequest<T> extends BaseRequest<T>{
    private PageModel page;

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }

    public BasePageRequest(ServiceContext clientInfo, T param, PageModel page) {
        super(clientInfo, param);
        this.page = page;
    }

    public BasePageRequest(T param, PageModel page) {
        super(param);
        this.page = page;
    }
}
