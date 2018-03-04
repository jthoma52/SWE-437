
public class TooManyKeywordsException extends Exception {
	
	private String message;

	public TooManyKeywordsException() {
		super();
	}

	public TooManyKeywordsException(String message) {
		super(message);
		this.message = message;
	}

	public String toString() {
		return message;
	}


}
