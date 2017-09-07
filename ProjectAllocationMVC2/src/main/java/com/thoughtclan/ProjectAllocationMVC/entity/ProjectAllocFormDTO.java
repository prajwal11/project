package com.thoughtclan.ProjectAllocationMVC.entity;

public class ProjectAllocFormDTO {
	private String employeeId;
	private String projectId;
	private int fullworkload;
	private int customworkload;

	public int getFullworkload() {
		return fullworkload;
	}

	public void setFullworkload(int fullworkload) {
		this.fullworkload = fullworkload;
	}

	public int getCustomworkload() {
		return customworkload;
	}

	public void setCustomworkload(int customworkload) {
		this.customworkload = customworkload;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
