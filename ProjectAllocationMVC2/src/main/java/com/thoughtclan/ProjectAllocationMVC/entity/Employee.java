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
import org.springframework.validation.annotation.Validated;

@Entity
public class Employee {

	@NotNull(message = "EmployeeId cannot be Null")
	@NotEmpty(message = "EmployeeId cannot be empty")
	@Id
	private String employeeId;

	@NotNull(message = "EmployeeName cannot be Null")
	@NotEmpty(message = "EmployeeName cannot be empty")
	private String employeeName;

	private int workload;

	// Project proj;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "employee_project_allocation", joinColumns
	 * = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"),
	 * inverseJoinColumns = @JoinColumn(name = "projectId", referencedColumnName =
	 * "projectId")) private List<Project> projectList = new ArrayList<Project>();
	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "employee_project_allocation", joinColumns
	 * = @JoinColumn(name = "employeeId", referencedColumnName = "employeeId"))
	 * private List<ProjAllocationForm> projectAllocationList = new
	 * ArrayList<ProjAllocationForm>();
	 * 
	 * 
	 * 
	 * 
	 * public List<ProjAllocationForm> getProjectAllocationList() { return
	 * projectAllocationList; }
	 * 
	 * public void setProjectAllocationList(List<ProjAllocationForm>
	 * projectAllocationList) { this.projectAllocationList = projectAllocationList;
	 * }
	 */

	@OneToMany(mappedBy = "employee")
	private List<ProjAllocationForm> allocationForms;
	
	

	public List<ProjAllocationForm> getAllocationForms() {
		return allocationForms;
	}

	public void setAllocationForms(List<ProjAllocationForm> allocationForms) {
		this.allocationForms = allocationForms;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	/*
	 * public List<Project> getProjectList() { return projectList; }
	 * 
	 * public void setProjectList(List<Project> projectList) { this.projectList =
	 * projectList; }
	 */
	public Employee() {

	}

	public Employee(String employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", workload=" + workload;
	}

}
