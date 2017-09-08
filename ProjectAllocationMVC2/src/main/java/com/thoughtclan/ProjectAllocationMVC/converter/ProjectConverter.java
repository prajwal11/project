package com.thoughtclan.ProjectAllocationMVC.converter;

import com.thoughtclan.ProjectAllocationMVC.DTO.ProjectDTO;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;

public class ProjectConverter {

	public Project convert(ProjectDTO projectDTO)
	{
		Project project = new Project();
		project.setProjectId(projectDTO.getProjectId());
		project.setProjectName(projectDTO.getProjectName());
		return project;
	}
	
	public ProjectDTO convert(Project project)
	{
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(project.getProjectId());
		projectDTO.setProjectName(project.getProjectName());
		return projectDTO;
	}
}
