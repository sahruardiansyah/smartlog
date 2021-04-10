package smartlog.exception;

public class EmailAlreadyExistException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6691197993405783119L;

	public EmailAlreadyExistException(String message) {
        super(message);
    }

    public EmailAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
