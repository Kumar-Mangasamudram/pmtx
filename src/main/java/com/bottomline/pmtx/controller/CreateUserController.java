package com.bottomline.pmtx.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bottomline.pmtx.payload.request.LoginRequest;
import com.bottomline.pmtx.payload.request.SignUpRequest;
import com.bottomline.pmtx.service.SignIn;
import com.bottomline.pmtx.service.SignUp;
import com.bottomline.pmtx.utils.JwtUtils;

import io.jsonwebtoken.Claims;

@RestController
public class CreateUserController {
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private SignIn signIn;
	
	@Autowired
	private SignUp signUp;
	
	@PostMapping("/signin")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> auntenticateUser(@RequestBody LoginRequest loginRequest){
		
		return signIn.authenticateUser(loginRequest);	
	}
	
	@PostMapping("/signup")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
		
		return signUp.registerUser(signUpRequest);
	}
	
	@GetMapping("/me")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public Claims auto(@RequestHeader(value="authorization") String auth) throws Exception {
		try {
		 Claims claims=jwtUtils.verify(auth);
		 
		 return claims;
		 }
		catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
		
		}
	}
	
}
