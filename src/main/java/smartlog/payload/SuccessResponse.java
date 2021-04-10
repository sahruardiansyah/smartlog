package smartlog.payload;

/**
 * SuccessResponse success message response wrapper class
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>message</b> String - success message </p>
 * <br>
 * @author Tom
 */
public class SuccessResponse {
    private String message;
    
    public SuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}