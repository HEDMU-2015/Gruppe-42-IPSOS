package exceptions;

public class PersistenceConnectionFailureException extends Exception {
	
	//TODO
	private static final long serialVersionUID = 1L;

	public PersistenceConnectionFailureException(String message) {
		super(message);
	}
}
