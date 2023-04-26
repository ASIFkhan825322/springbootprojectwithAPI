package org.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.User;
import org.jsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
		
	}
	public User updateUser(User user) {
		return repository.save(user);
		
	}
	public  Optional<User>findUserById(int id){
		return repository.findById(id);
		
		
	}
	public void delete(User user) {
		repository.delete(user);
	}
	public List<User> findAll(){
		return repository.findAll();
		
	}
	public Optional<User> verifyUser(long phone,String password){
		return repository.verifyUser(phone, password);
	}

}
