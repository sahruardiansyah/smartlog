package smartlog.payload;

import java.util.List;

/**
 * SuccessListResponse List response wrapper class, extends from {@link SuccessResponse}
 * Generic data type
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>list</b> List of Generic data type - data content</p>
 * <br>
 * @author Tom
 */
public class SuccessListResponse<T> extends SuccessResponse {
    private List<T> list;
    
    public SuccessListResponse(String message, List<T> list) {
    	super(message);
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}