package com.thoughtclan.ProjectAllocationMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.ProjectAllocationMVC.entity.ProjAllocationForm;
import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;

@Repository
public interface ProjAllocationFormRepository extends CrudRepository<ProjAllocationForm,Long>{
	ProjAllocationForm findAllByEmployee(List<Employee> list);
	ProjAllocationForm findAllByProject(List<Project> list);
}
