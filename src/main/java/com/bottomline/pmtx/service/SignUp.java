package com.bottomline.pmtx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bottomline.pmtx.model.User;
import com.bottomline.pmtx.payload.request.SignUpRequest;
import com.bottomline.pmtx.repository.UserRepository;


@Service
public class SignUp {
	
	@Autowired
	private UserRepository repo;
	
	
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		
		User check = repo.getByEmail(signUpRequest.getEmail());
		
		if(check != null) {
			return new ResponseEntity<>("User with this email already exists", HttpStatus.BAD_REQUEST);
		}
		
		
		User user = new User(signUpRequest.getName(),
				signUpRequest.getEmail(),
				signUpRequest.getPassword(),
				signUpRequest.getRole()
				);
		
		repo.save(user);


		return new ResponseEntity<>("User registered succesfully", HttpStatus.OK);
	}
}
