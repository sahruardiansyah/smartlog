package smartlog.payload;

import java.util.List;

/**
 * PagedResponse Page response wrapper class 
 * Generic data type
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>list</b> List - data content</p>
 * <p><b>page</b> int - page index, start from zero</p>
 * <p><b>size</b> int - page size (maximum number of item)</p>
 * <p><b>totalElements</b> int - total number of record found</p>
 * <p><b>totalPages</b> int - total number of pages found</p>
 * <p><b>last</b> boolean - is current page the last?</p>
 * <br>
 * @author Tom
 */
public class PagedResponse<T> {
	
    private List<T> list;
    
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public PagedResponse() {

    }

    public PagedResponse(List<T> list, int page, int size, long totalElements, int totalPages, boolean last) {
        this.list = list;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
