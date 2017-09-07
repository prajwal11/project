package com.thoughtclan.ProjectAllocationMVC.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, String>{

	List<Project> findByProjectName(String projectName);
}
