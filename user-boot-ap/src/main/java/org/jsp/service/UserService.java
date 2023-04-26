package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.UserDao;
import org.jsp.dto.ResponseStructure;
import org.jsp.dto.User;
import org.jsp.exception.IdNotFoundException;
import org.jsp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> st = new ResponseStructure<>();
		st.setBody(dao.saveUser(user));
		st.setMessage("user register with ID:" + user.getId());
		st.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(st, HttpStatus.ACCEPTED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> st = new ResponseStructure<>();
		st.setBody(dao.updateUser(user));
		st.setMessage("user updated sussfully");
		st.setCode(HttpStatus.ACCEPTED.value());
        return new ResponseEntity<ResponseStructure<User>>(st,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		ResponseStructure<User> st = new ResponseStructure<>();

		Optional<User> u = dao.findUserById(id);
		if (u.isPresent()) {
			st.setBody(u.get());
			st.setMessage("user found");
			st.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(st, HttpStatus.FOUND);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		Optional<User> u = dao.findUserById(id);
		ResponseStructure<String> st = new ResponseStructure<String>();

		if (u.isPresent()) {
			st.setBody("user deleted");
			st.setMessage("user found");
			st.setCode(HttpStatus.OK.value());
			dao.delete(u.get());

			return new ResponseEntity<ResponseStructure<String>>(st, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> st = new ResponseStructure<>();
		st.setBody(dao.findAll());
		st.setMessage("List of All User");
		st.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(st,HttpStatus.OK);

	}
    
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> st=new ResponseStructure<>();
		Optional<User> vUser =dao.verifyUser(phone, password);
		if (vUser.isPresent()) {
			st.setBody(vUser.get());
			st.setMessage("verification succesfull");
			st.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(st,HttpStatus.OK);
		}
		
		throw new InvalidCredentialException();
	}
}
