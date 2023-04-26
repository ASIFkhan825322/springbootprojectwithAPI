package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dao.UserDao;
import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public User saveUser(User user) {
		return dao.saveUser(user);
	}

	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	public User findUserById(int id) {
		Optional<User> u = dao.findUserById(id);
		if (u.isPresent()) {
			return u.get();
		}
		return null;
	}

	public String delete(int id) {
		Optional<User> u = dao.findUserById(id);
		if (u.isPresent()) {
			dao.delete(u.get());
			return "user deleted";
		} else {
			return "Invalid Id";
		}

	}

	public List<User> findAll() {
		return dao.findAll();
	}
}
