package exceptions;

public class AuthenticationException extends Exception{
	
	public AuthenticationException() {
		super("Username / Password Salah");
	}
	
	public AuthenticationException(String message) {
		super(message);
	}

}
