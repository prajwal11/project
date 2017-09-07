package com.thoughtclan.ProjectAllocationMVC.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Project {

	@NotEmpty(message = "ProjectId cannot be Empty")
	@NotNull(message = "ProjectId cannot be Null")
	@Id
	private String projectId;

	@NotEmpty(message = "ProjectName cannot be Empty")
	@NotNull(message = "ProjectName cannot be Null")
	private String projectName;

/*	@ManyToMany(mappedBy="projectList",fetch=FetchType.EAGER)
	private List<Employee> employeeList = new ArrayList<Employee>();
*/
	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_project_allocation", joinColumns = @JoinColumn(name = "projectId", referencedColumnName = "projectId"))
	private List<ProjAllocationForm> projectAllocationList = new ArrayList<ProjAllocationForm>();

	*/
	
	/*
	public List<ProjAllocationForm> getProjectAllocationList() {
		return projectAllocationList;
	}

	public void setProjectAllocationList(List<ProjAllocationForm> projectAllocationList) {
		this.projectAllocationList = projectAllocationList;
	}

*/	public Project() {
	}

	public Project(String projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
/*
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}*/

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName;
	}

}
