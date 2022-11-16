package com.bottomline.pmtx.service;


import org.springframework.http.ResponseEntity;

import com.bottomline.pmtx.payload.request.NewtaskDto;

public interface TaskServiceInterface {

	public ResponseEntity<?> addtask(NewtaskDto task);
	
	public ResponseEntity<?> showTask(int taskId);
	
	public ResponseEntity<?> changeTaskStatus(int taskId);
	
	public ResponseEntity<?> pendingTasks(int userId);
	
	public ResponseEntity<?> completedTasks(int userId);
}
