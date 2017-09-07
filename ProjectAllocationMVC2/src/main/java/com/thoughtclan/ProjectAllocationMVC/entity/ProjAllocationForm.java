package com.thoughtclan.ProjectAllocationMVC.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_project_allocation")
public class ProjAllocationForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long allocationId;
	
	@ManyToOne(targetEntity = Employee.class)
	private Employee employee;

	@ManyToOne(targetEntity = Project.class)
	private Project project;
	
	private int workload;
	
	

	public Long getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(Long allocationId) {
		this.allocationId = allocationId;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "ProjAllocationForm [employee=" + employee.getEmployeeName() + ", project=" + project.getProjectName()
				+ "]";
	}

}
