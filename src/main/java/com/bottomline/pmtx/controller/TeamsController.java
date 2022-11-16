package com.bottomline.pmtx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bottomline.pmtx.service.TeamsService;
import com.bottomline.pmtx.utils.JwtUtils;


@RestController
@RequestMapping("/teams")
public class TeamsController {
	
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private TeamsService teamsService;
	
	@GetMapping("/employees")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> getTeamList(@RequestHeader(value="authorization") String auth) throws Exception
	{
		try {
			jwtUtils.verify(auth);
			return teamsService.getTeamList();
		}catch(Exception e)
		{
			return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
