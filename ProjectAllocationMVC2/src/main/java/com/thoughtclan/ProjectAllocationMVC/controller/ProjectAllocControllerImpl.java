package com.thoughtclan.ProjectAllocationMVC.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thoughtclan.ProjectAllocationMVC.DTO.EmployeeDTO;
import com.thoughtclan.ProjectAllocationMVC.DTO.ProjectDTO;
import com.thoughtclan.ProjectAllocationMVC.converter.EmployeeConverter;
import com.thoughtclan.ProjectAllocationMVC.converter.ProjectConverter;
import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.ProjAllocationForm;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;
import com.thoughtclan.ProjectAllocationMVC.entity.ProjectAllocFormDTO;
import com.thoughtclan.ProjectAllocationMVC.service.ProjectAllocationServiceOperations;
import com.thoughtclan.ProjectAllocationMVC.validation.AllocationValidator;

@Controller
public class ProjectAllocControllerImpl {
	List<Employee> empList = new ArrayList<Employee>();

	@Autowired
	ProjectAllocationServiceOperations ProjectAllocBean;

	private static final Logger log = LoggerFactory.getLogger(ProjectAllocControllerImpl.class);

	@GetMapping("/")
	public String sayHello(ModelMap model) {
		return "welcome";
	}

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.addValidators(new AllocationValidator()); }
	 */

	@GetMapping("/add")
	public String add(ModelMap model) {
		List<Employee> emplist = new ArrayList<Employee>();
		List<Project> projlist = new ArrayList<Project>();
		emplist = ProjectAllocBean.getEmpList();
		projlist = ProjectAllocBean.getProjList();
		model.addAttribute("emplist", emplist);
		model.addAttribute("projlist", projlist);
		model.addAttribute("allocForm", new ProjectAllocFormDTO());
		return "add";
	}

	@GetMapping("/update")
	public String update(ModelMap model) {
		return "update";
	}

	@GetMapping("/delete")
	public String delete(ModelMap model) {
		return "delete";
	}

	@RequestMapping("/addemp")
	public String addemp(ModelMap model) {
		EmployeeDTO eObj = new EmployeeDTO();
		model.addAttribute("employeedetails", eObj);
		// String emp = "";
		// model.addAttribute("EmployeeObject",emp);
		return "addemp";
	}

	@RequestMapping("/addproj")
	public String addproj(ModelMap model) {
		ProjectDTO pObj = new ProjectDTO();
		model.addAttribute("projdetails", pObj);
		return "addproj";
	}

	@GetMapping("/search")
	public String search(ModelMap model) {
		return "search";
	}

	@GetMapping("/addval")
	public String add(ModelMap model, @ModelAttribute(name = "allocForm") ProjectAllocFormDTO pObj) {

		// pObj.setWorkload(pObj.getFullworkload(), pObj.getCustomworkload());
		int workload = pObj.getCustomworkload() + pObj.getFullworkload();
		int flag = ProjectAllocBean.addproject(pObj.getEmployeeId(), pObj.getProjectId(), workload);
		if(flag>1)
		{
			String message = "Employee is assigned with ";
			model.addAttribute("message", message);
			model.addAttribute("workload",flag);
			return "add";
		}
		else
		{
			return "welcome";
		}
	}

	@GetMapping("/addempval")
	public String addempval(ModelMap model, @Valid @ModelAttribute(name = "employeedetails") EmployeeDTO eObj,
			BindingResult result) {

		EmployeeConverter employeeConverter = new EmployeeConverter();
		Employee employee = employeeConverter.convert(eObj);
		if (result.hasErrors()) {
			return "addemp";
		} else {

			boolean flag = ProjectAllocBean.addemp(employee.getEmployeeId(), employee.getEmployeeName());
			if (!flag) {
				String message = "Employee Id Already Exist";
				model.addAttribute("message", message);
				return "addemp";
			} else {
				return "welcome";
			}

		}
	}

	@GetMapping("/addprojval")
	public String addprojval(ModelMap model, @Valid @ModelAttribute(name = "projdetails") ProjectDTO pObj,
			BindingResult result) {

		ProjectConverter projectConverter = new ProjectConverter();
		Project project = projectConverter.convert(pObj);
		if (result.hasErrors()) {
			return "addproj";
		} else {
			boolean flag = ProjectAllocBean.addproj(project.getProjectId(), project.getProjectName());
			if (!flag) {
				String message = "Project Id Already Exist";
				model.addAttribute("message", message);
				return "addproj";
			} else {
				return "welcome";
			}

		}
	}

	/*
	 * @GetMapping("/updateval") public String updateval(ModelMap
	 * model, @RequestParam(value = "empid", defaultValue = "0") String empid,
	 * 
	 * @RequestParam(value = "projid", defaultValue = "0") String projid,
	 * 
	 * @RequestParam(value = "projname", defaultValue = "Java") String projname) {
	 * 
	 * test.updateproject(empid, projid, projname); // model.addAttribute("empid",
	 * empid); return "welcome"; }
	 */

	@RequestMapping("/deleteval")
	public String delete(ModelMap model, @RequestParam(value = "employeeName", defaultValue = "0") String employeeName,
			@RequestParam(value = "projectName", defaultValue = "0") String projectName) {
		boolean flag = ProjectAllocBean.delete(employeeName, projectName);
		if (!flag) {
			String message = " is not allocated to Project ";
			model.addAttribute("employeeName", employeeName);
			model.addAttribute("projectName", projectName);
			model.addAttribute("message", message);
			return "delete";
		} else
			return "welcome";
	}

	@RequestMapping("/searchval")
	public String search(ModelMap model, @RequestParam(value = "empid", defaultValue = "0") String empid) {
		List<ProjAllocationForm> emp;
		emp = ProjectAllocBean.search(empid);
		model.addAttribute("Employee", emp);
		return "/searchview";
	}


	@RequestMapping("/view")
	public String view(ModelMap model) {
		List<ProjAllocationForm> empProjlist = ProjectAllocBean.view();
		List<Employee> emplist = new ArrayList<Employee>();
		List<Project> projlist = new ArrayList<Project>();
		emplist = ProjectAllocBean.getEmpList();
		projlist = ProjectAllocBean.getProjList();
		model.addAttribute("employeelist", emplist);
		model.addAttribute("projlist", projlist);
		model.addAttribute("empList", empProjlist);

		Employee emp = new Employee();
		emp.setEmployeeId("1");
		;
		//List<Object> list = customProjAllocRepository.findAllocationsForEmployee(emp);


		return "/view";
	}
}
