package smartlog.exception;

public class PhoneAlreadyExistException extends RuntimeException {
    private static final long serialVersionUID = -1937081225382963947L;

    public PhoneAlreadyExistException(String message){
        super(message);
    }
    public PhoneAlreadyExistException(String message,Throwable cause){
        super(message,cause);
    }
}
