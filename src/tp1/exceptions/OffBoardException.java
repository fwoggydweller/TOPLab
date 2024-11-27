package tp1.exceptions;

public class OffBoardException extends ObjectParseException{
	public OffBoardException() {
        super();
    }

    public OffBoardException(String message) {
        super(message);
    }

    public OffBoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public OffBoardException(Throwable cause) {
        super(cause);
    }
}
