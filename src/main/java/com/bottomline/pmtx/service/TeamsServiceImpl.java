package com.bottomline.pmtx.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bottomline.pmtx.model.Task;
import com.bottomline.pmtx.model.User;
import com.bottomline.pmtx.payload.response.EmployeeResponse;
import com.bottomline.pmtx.repository.TaskRepository;
import com.bottomline.pmtx.repository.UserRepository;


@Service
public class TeamsServiceImpl implements TeamsService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public ResponseEntity<?> getTeamList() {
		// TODO Auto-generated method stub
		List<User> allEmployees = userRepo.findAllByRole("EMP");

		List<EmployeeResponse> employeeResponse = new ArrayList<>();
		for(User user : allEmployees) {
			EmployeeResponse employee = new EmployeeResponse();
			
			employee.setUserId(user.getId());
			
			employee.setUserName(user.getName());
			
			List<Task> listPending = taskRepo.findAllByUserId(user.getId());
			long countOfPendingTask = 0;
			for(Task task : listPending) {
				if(task.isStatus()!=true) {
					countOfPendingTask++;
				}
			}
			
			employee.setNoOfPendingtask(countOfPendingTask);
			
			List<Task> listCompleted = taskRepo.findAllByUserId(user.getId());
			long countOfCompletedTask = 0;
			
			for(Task task: listCompleted)
			{
				if(task.isStatus()!=false) {
					countOfCompletedTask++;
				}
			}
			
			employee.setNoOfCompletedTask(countOfCompletedTask);
			
			employeeResponse.add(employee);
			
		}
		
		return new ResponseEntity<>(employeeResponse, HttpStatus.OK);		
	}

}
