package com.thoughtclan.ProjectAllocationMVC.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

//import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.LoggerFactory;
//import com.sun.istack.internal.logging.Logger;
import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.ProjAllocationForm;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;
import com.thoughtclan.ProjectAllocationMVC.repository.EmployeeRepository;
import com.thoughtclan.ProjectAllocationMVC.repository.ProjAllocationFormRepository;
import com.thoughtclan.ProjectAllocationMVC.repository.ProjectRepository;

@Service
public class ProjectAllocationOperations {
	List<Employee> employeeList = new ArrayList<Employee>();
	Project proj;
	List<Project> projectList = new ArrayList<Project>();
	List<Employee> empList1 = new ArrayList<Employee>();
	List<ProjAllocationForm> ProjectAllocList = new ArrayList<ProjAllocationForm>();

	private static final Logger log = LoggerFactory.getLogger(ProjectAllocationOperations.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjAllocationFormRepository projallocRep;

	@Autowired
	ProjAllocUtils utils;

	public ProjAllocUtils allocProjectToDb(Employee employee, Project project, int workload) {
		ProjAllocationForm projalloc = new ProjAllocationForm();
		projalloc.setEmployee(employee);
		projalloc.setProject(project);
		projalloc.setWorkload(workload);

		projallocRep.save(projalloc);

		return new ProjAllocUtils();

	}

	public ProjAllocUtils addProjectToDb(String projid, String projname) {
		log.info("Save the Project Details in Project Database");
		projectRepository.save(new Project(projid, projname));
		log.error("Error in saving Project Details");
		log.error("Project Details not saved");
		return new ProjAllocUtils();

	}

	public ProjAllocUtils addEmployeeToDb(String empid, String empname, int workload) {
		Employee emp = new Employee(empid, empname);
		emp.setWorkload(workload);
		log.info("Save the Employee Details in Employee Database");
		employeeRepository.save(emp);
		log.error("Error in saving Employee Details");
		log.error("Employee Details not saved");
		return new ProjAllocUtils();
	}

	@Transactional
	public List<Employee> getEmpList() {
		employeeList = (List<Employee>) employeeRepository.findAll();

		log.info("Printing employee info.");
		for (Employee employee : employeeList) {
			log.info("Employee details : " + employee);
		}

		return employeeList;
	}

	public List<Project> getProjList() {
		projectList = (List<Project>) projectRepository.findAll();
		log.info("Project List is Created");
		return projectList;
	}

	public void addemp(String employeeid, String employeename) {
		employeeList = (List<Employee>) employeeRepository.findAll();
		if (!employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				if (employee.getEmployeeId().equals(employeeid)) {
					log.info("Employee Already Exist");
					return;
				}
			}
		}
		log.info("Creating new Employee");
		addEmployeeToDb(employeeid, employeename, 0);
	}

	public void addproj(String projectid, String projectname) {
		projectList = (List<Project>) projectRepository.findAll();
		if (!projectList.isEmpty()) {
			for (Project project : projectList) {
				if (project.getProjectId().equals(projectid)) {
					log.info("Project Already Exist");
					return;
				}
			}
		}
		log.info("Creating new Project");
		addProjectToDb(projectid, projectname);
	}

	public void addproject(String empid, String projid, int workload) {
		employeeList = (List<Employee>) employeeRepository.findAll();
		projectList = (List<Project>) projectRepository.findAll();
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId().equals(empid)) {
				for (Project project : projectList) {
					if (project.getProjectId().equals(projid)) {
						int empworkload = 0;
						empworkload = workload + employee.getWorkload();
						if (empworkload > 100) {
							log.info("The employee is Assigned with 100% workload");
							return;
						} else {
							log.info("New Project is allocated to Employee");
							ProjAllocationForm alloc = new ProjAllocationForm();
							allocProjectToDb(employee, project, workload);
							addEmployeeToDb(employee.getEmployeeId(), employee.getEmployeeName(), empworkload);
							return;
						}
					}
				}
			}
		}
		log.info("The Project is already Allocated");
		return;
	}

	public void delete(String empid, String projid) {
		ProjectAllocList = (List<ProjAllocationForm>) projallocRep.findAll();
		employeeList = (List<Employee>) employeeRepository.findAll();
		for (ProjAllocationForm projalloc : ProjectAllocList) {
			if (projalloc.getEmployee().getEmployeeId().equals(empid)) {
				if (projalloc.getProject().getProjectId().equals(projid)) {
					int work, newworkload;
					for (Employee employee : employeeList) {
						if (employee.getEmployeeId().equals(empid)) {
							work = employee.getWorkload();
							newworkload = work - projalloc.getWorkload();
							log.info("Reseting the Workload of Employee");
							addEmployeeToDb(employee.getEmployeeId(), employee.getEmployeeName(), newworkload);
						}
					}
					log.info("The Allocated Project is deleted");
					projallocRep.delete(projalloc);
				}
			}
		}
		log.info("No Allocation Exist");
	}

	public List<ProjAllocationForm> view() {
		ProjectAllocList = (List<ProjAllocationForm>) projallocRep.findAll();
		log.info("Project Allocation List is Created");
		return ProjectAllocList;
	}

	public List<ProjAllocationForm> search(String query) {
		List<ProjAllocationForm> employeeDetails = new ArrayList<ProjAllocationForm>();
		ProjectAllocList = (List<ProjAllocationForm>) projallocRep.findAll();
		if (!ProjectAllocList.isEmpty()) {
			for (ProjAllocationForm projalloc : ProjectAllocList) {
				if (projalloc.getEmployee().getEmployeeId().equals(query)
						|| projalloc.getEmployee().getEmployeeName().equals(query)) {
					log.info("Employee Details is matched");
					employeeDetails.add(projalloc);
				}
				if (projalloc.getProject().getProjectId().equals(query)
						|| projalloc.getProject().getProjectName().equals(query)) {
					log.info("Project Details is matched");
					employeeDetails.add(projalloc);
				}
			}
		}
		log.info("Employee Details List is created");
		return employeeDetails;
	}

}
