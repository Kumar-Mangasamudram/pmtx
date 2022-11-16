package com.bottomline.pmtx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	public Task(int taskId, String taskName, String description, User user, String assignedTo, boolean status, User user1) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.status = status;
		this.user = user1;
	}

	public Task() {
		super();
	}

	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int taskId;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
