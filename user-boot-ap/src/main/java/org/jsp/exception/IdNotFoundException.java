package org.jsp.exception;
@SuppressWarnings("all")
public class IdNotFoundException extends RuntimeException {
@Override
public String getMessage() {
	return "id is not present";
	
}
}
