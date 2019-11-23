package com.satrabench.getfriends.service;

import com.satrabench.getfriends.model.Incident;
import com.satrabench.getfriends.model.User;
import com.satrabench.getfriends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

    @Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<Object> getAll(){
    	List<User> users = userRepository.findAll();
		return new ResponseEntity<Object>(users, HttpStatus.OK);
}

	public ResponseEntity<Object> create(User user){
    	User u = userRepository.save(user);
		return new ResponseEntity<Object>(u, HttpStatus.OK);
	}

	public ResponseEntity<Object> authentication(String name, String password) {
    	if(userRepository.findByNameAndPassword(name,password) == null)return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(userRepository.findByNameAndPassword(name, password), HttpStatus.OK);
	}

}
