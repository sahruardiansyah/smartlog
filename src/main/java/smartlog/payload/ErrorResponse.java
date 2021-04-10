package smartlog.payload;

/**
 * ErrorResponse Error response wrapper class
 * <br>
 * <br>
 * <p><b>Attributes: </b></p>
 * <p><b>error</b> String - Describe generic error message</p>
 * <p><b>message</b> String - Detail message to describe the specific error and the cause</p>
 * <p><b>code</b> int - Internal error code</p>
 * <br>
 * @author Tom
 */
public class ErrorResponse {
	
	private String error;
    private String message;
    private int code;
        
    public ErrorResponse(String error, String message, int code) {
        this.error = error;
        this.message = message;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
