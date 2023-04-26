package org.jsp.controller;

import java.util.List;

import org.jsp.dto.User;
import org.jsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
 private UserService service;
 @PostMapping("/user")
 public User saveUser(@RequestBody User user) {
	 return service.saveUser(user);
 }
 @PutMapping("/user")
 public User updateUser(@RequestBody User user) {
	 return service.updateUser(user);
 }
 @GetMapping("/user/{id}")
 public User findUserById(@PathVariable int id) {
	 return service.findUserById(id);
 }
 @DeleteMapping("/user/{id}")
 public String deleteUser(@PathVariable int id) {
	 return service.delete(id);
 }
 @GetMapping("/user")
 public List<User> findAll(){
	 return service.findAll();
 }
 
 
}
