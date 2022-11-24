package info.ashutosh.exception;

public class APINotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APINotFoundException() {
		super();
	}

	public APINotFoundException(String message) {
		super(message);
	}
}
