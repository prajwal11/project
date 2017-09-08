package com.thoughtclan.ProjectAllocationMVC.converter;

import com.thoughtclan.ProjectAllocationMVC.DTO.EmployeeDTO;
import com.thoughtclan.ProjectAllocationMVC.entity.Employee;

public class EmployeeConverter{

	public Employee convert(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setEmployeeName(employeeDTO.getEmployeeName());
		employee.setWorkload(employeeDTO.getWorkload());
		return employee;
	}
	
	public EmployeeDTO convert(Employee employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setEmployeeName(employee.getEmployeeName());
		employeeDTO.setWorkload(employee.getWorkload());
		return null;
	}
}
