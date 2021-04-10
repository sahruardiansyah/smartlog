package smartlog.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7560987298070967429L;
	
	public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}