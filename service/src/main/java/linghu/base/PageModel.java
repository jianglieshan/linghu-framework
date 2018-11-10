package linghu.base;

public class PageModel {

    private long pageNum;
    private long pageSize;
    private long total;
    private long pages;
    private long skips;

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        pageSize = pageSize<=0?10:pageSize;
        if(total%pageSize == 0){
            pages = total/pageSize;
        }
        else{
            pages = total/pageSize + 1;
        }
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getSkips() {
        return (pageNum-1) * pageSize;
    }

//    public void setSkips(long skips) {
//        this.skips = skips;
//    }



    public PageModel() {
    }


    public PageModel(long pageNum, long pageSize, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

    public static PageModel defaultPage(){
        PageModel p = new PageModel();
        p.pageNum = 1;
        p.pageSize = 10;
        return p;
    }
}
