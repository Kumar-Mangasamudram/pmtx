package com.bottomline.pmtx.payload.response;

import java.util.List;

public class TeamResponse {
	List<EmployeeResponse> employeesResponse;

	public List<EmployeeResponse> getEmployeesResponse() {
		return employeesResponse;
	}

	public void setEmployeesResponse(List<EmployeeResponse> employeesResponse) {
		this.employeesResponse = employeesResponse;
	}
}
