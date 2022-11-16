package com.bottomline.pmtx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bottomline.pmtx.model.Task;
import com.bottomline.pmtx.model.User;
import com.bottomline.pmtx.payload.request.NewtaskDto;
import com.bottomline.pmtx.payload.response.TaskResponse;
import com.bottomline.pmtx.repository.TaskRepository;
import com.bottomline.pmtx.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskServiceInterface {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TaskRepository taskRepo;
	
	@Override
	public ResponseEntity<?> addtask(NewtaskDto task) {
		
		Task taskAdd = new Task();
		taskAdd.setTaskName(task.getTaskName());
		taskAdd.setDescription(task.getDescription());
		User user = userRepo.getById((long) task.getUserId());
		taskAdd.setUser(user);
		taskAdd.setStatus(false);
		
		taskRepo.save(taskAdd);
		
		return new ResponseEntity<>("Task Created Successfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> showTask(int taskId) {
		Optional<Task> task =  taskRepo.findBytaskId(taskId);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> changeTaskStatus(int taskId) {
		Optional<Task> currTask = taskRepo.findBytaskId(taskId);
		Task updatedTask = currTask.get();
		updatedTask.setStatus(true);
		taskRepo.save(updatedTask);
		
		return new ResponseEntity<>("Status changed successfully", HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> pendingTasks(int userId) {
		System.out.print("in service");
		List<Task> listPending = taskRepo.findAllByUserId(userId);
		List<TaskResponse> taskResponse = new ArrayList<>();
		for(Task task: listPending)
		{
			if(task.isStatus()!=true) {
				TaskResponse newTask = new TaskResponse();
				newTask.setTaskId(task.getTaskId());
				newTask.setTaskName(task.getTaskName());
				newTask.setDescription(task.getDescription());
				newTask.setStatus(task.isStatus());
				User user = task.getUser();
				newTask.setUserId(user.getId());
				
				taskResponse.add(newTask);
				
			}
		}
		return new ResponseEntity<>(taskResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> completedTasks(int userId) {
		List<Task> listPending = taskRepo.findAllByUserId(userId);
		List<TaskResponse> taskResponse = new ArrayList<>();	
		
		for(Task task: listPending)
		{
			if(task.isStatus()!=false) {
				TaskResponse newTask = new TaskResponse();
				newTask.setTaskId(task.getTaskId());
				newTask.setTaskName(task.getTaskName());
				newTask.setDescription(task.getDescription());
				newTask.setStatus(task.isStatus());
				User user = task.getUser();
				newTask.setUserId(user.getId());
				
				taskResponse.add(newTask);
			}
		}
		return new ResponseEntity<>(taskResponse, HttpStatus.OK);
	}

}
