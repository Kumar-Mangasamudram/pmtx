package com.bottomline.pmtx.payload.request;

public class NewtaskDto {
	public NewtaskDto() {
		super();
	}

	public NewtaskDto(String taskName, String description, long userId) {
		super();
		this.taskName = taskName;
		this.description = description;
		this.userId = userId;
	}

	private String taskName;

	private String description;
	
	private long userId;
	
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
