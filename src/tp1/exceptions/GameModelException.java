package tp1.exceptions;

public class GameModelException extends CommandException{
	public GameModelException() {
        super();
    }

    public GameModelException(String message) {
        super(message);
    }

    public GameModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameModelException(Throwable cause) {
        super(cause);
    }
}
