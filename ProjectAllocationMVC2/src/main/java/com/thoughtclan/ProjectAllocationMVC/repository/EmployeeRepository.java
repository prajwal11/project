package com.thoughtclan.ProjectAllocationMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.ProjectAllocationMVC.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

	List<Employee> findByEmployeeName(String employeeName);
	//Employee findOneById(Long id);
}
