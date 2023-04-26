package org.jsp.exception;

import org.jsp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class UserAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<ResponseStructure<String>> handelIdNotFoundException(IdNotFoundException e) {
		ResponseStructure<String> st = new ResponseStructure<>();
		st.setCode(HttpStatus.NOT_FOUND.value());
		st.setMessage(e.getMessage());
		st.setBody("user not found");
		return new ResponseEntity<ResponseStructure<String>>(st, HttpStatus.NOT_FOUND);

	}
    @ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handelICE(InvalidCredentialException e) {
		ResponseStructure<String> st = new ResponseStructure<>();
		st.setCode(HttpStatus.NOT_FOUND.value());
		st.setMessage(e.getMessage());
		st.setMessage("Invalid phone no and password");
		return new ResponseEntity<ResponseStructure<String>>(st, HttpStatus.NOT_FOUND);

	}
}
