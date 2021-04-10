package smartlog.payload;

/**
 * SuccessDataResponse Object response wrapper class, extends from {@link SuccessResponse}
 * Generic data type
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>data</b> Generic data type - data content</p>
 * <br>
 * @author Tom
 */
public class SuccessDataResponse<T> extends SuccessResponse {
    private T data;
    
    public SuccessDataResponse(String message, T data) {
    	super(message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
