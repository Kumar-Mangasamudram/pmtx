package com.bottomline.pmtx.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bottomline.pmtx.payload.request.NewtaskDto;
import com.bottomline.pmtx.service.TaskServiceInterface;
import com.bottomline.pmtx.utils.JwtUtils;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private TaskServiceInterface taskService;
	
	@PostMapping("/add")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> addTask(@RequestBody NewtaskDto task, @RequestHeader(value="authorization") String auth) throws Exception {
		try {
		jwtUtils.verify(auth);
		System.out.print("in controller");
		return taskService.addtask(task);
		}catch(Exception e) {
            return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		
		}
		
	}
	
	@GetMapping("/{id}")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> showTask(@PathVariable("id") int taskId, @RequestHeader(value="authorization") String auth) throws Exception {
		try {
		jwtUtils.verify(auth);
		return taskService.showTask(taskId);
		}catch(Exception e) {
			return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		
		}
	}
	
	@PutMapping("/{id}")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> changeTaskStatus(@PathVariable("id") int taskId, @RequestHeader(value="authorization") String auth) throws Exception
	{
		try {
			jwtUtils.verify(auth);
			return taskService.changeTaskStatus(taskId);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/pending/{userId}")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> pendingTasks(@PathVariable("userId") int userId,  @RequestHeader(value="authorization") String auth) throws Exception
	{
		try {
			jwtUtils.verify(auth);
			return taskService.pendingTasks(userId);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/completed/{userId}")
	//@CrossOrigin(origins={"http://localhost:8080", "https://pmt-x.herokuapp.com"})
	public ResponseEntity<?> completedTasks(@PathVariable("userId") int userId,  @RequestHeader(value="authorization") String auth) throws Exception
	{
		try {
			jwtUtils.verify(auth);
			return taskService.completedTasks(userId);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Access Denied!", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
