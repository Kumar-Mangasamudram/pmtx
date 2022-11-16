package com.bottomline.pmtx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bottomline.pmtx.model.User;
import com.bottomline.pmtx.payload.request.LoginRequest;
import com.bottomline.pmtx.repository.UserRepository;
import com.bottomline.pmtx.utils.JwtUtils;

@Service
public class SignIn {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
			
		User user = repo.getByEmail(loginRequest.getEmail());
		
		if(user != null) {
			String userPassword = user.getPassword();
			String loginPassword = loginRequest.getPassword();
			if(userPassword.equals(loginPassword)) {
				String token = jwtUtils.generateJwt(user);
				return new ResponseEntity<>(token,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Password Not matched", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return new ResponseEntity<>("User Not found", HttpStatus.BAD_REQUEST);
		}
	}
}
