package com.bottomline.pmtx.payload.response;

public class EmployeeResponse {
	private long userId;
	
	private String userName;
	
	private long noOfPendingtask;

	private long noOfCompletedTask;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getNoOfPendingtask() {
		return noOfPendingtask;
	}

	public void setNoOfPendingtask(long noOfPendingtask) {
		this.noOfPendingtask = noOfPendingtask;
	}

	public long getNoOfCompletedTask() {
		return noOfCompletedTask;
	}

	public void setNoOfCompletedTask(long noOfCompletedTask) {
		this.noOfCompletedTask = noOfCompletedTask;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
