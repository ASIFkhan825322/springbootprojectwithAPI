package org.jsp.exception;
@SuppressWarnings("all")
public class InvalidCredentialException extends RuntimeException {
   @Override
public String getMessage() {
	return "Invalid Credential";
}
}
