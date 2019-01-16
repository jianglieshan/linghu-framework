package linghu.base;

public class BaseActionPageRequest extends BaseActionRequest {
    private PageModel page;

    public PageModel getPage() {
        return page;
    }

    public void setPage(PageModel page) {
        this.page = page;
    }

    public BaseActionPageRequest() {
    }
}
