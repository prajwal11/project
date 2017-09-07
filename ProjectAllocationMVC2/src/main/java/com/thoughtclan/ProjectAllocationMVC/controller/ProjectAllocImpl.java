package com.thoughtclan.ProjectAllocationMVC.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

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

import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.ProjAllocationForm;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;
import com.thoughtclan.ProjectAllocationMVC.entity.ProjectAllocFormDTO;
import com.thoughtclan.ProjectAllocationMVC.service.ProjectAllocationOperations;
import com.thoughtclan.ProjectAllocationMVC.validation.AllocationValidator;

@Controller
public class ProjectAllocImpl {
	List<Employee> empList = new ArrayList<Employee>();

	@Autowired
	ProjectAllocationOperations ProjectAllocBean;

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
		Employee eObj = new Employee();
		model.addAttribute("employeedetails", eObj);
		return "addemp";
	}

	@RequestMapping("/addproj")
	public String addproj(ModelMap model) {
		Project pObj = new Project();
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
		ProjectAllocBean.addproject(pObj.getEmployeeId(), pObj.getProjectId(), workload);
		System.out.println("__________workload " + workload);
		model.addAttribute("empid", pObj.getEmployeeId());
		return "welcome";
	}

	@GetMapping("/addempval")
	public String addempval(ModelMap model, @Valid @ModelAttribute(name = "employeedetails") Employee eObj,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addemp";
		} else {
			ProjectAllocBean.addemp(eObj.getEmployeeId(), eObj.getEmployeeName());
			// model.addAttribute("emp", emp);
			// model.addAttribute("empname", empname);
			return "welcome";
		}
	}

	@GetMapping("/addprojval")
	public String addprojval(ModelMap model, @Valid @ModelAttribute(name = "projdetails") Project pObj,
			BindingResult result) {

		if (result.hasErrors()) {
			return "addproj";
		} else {
			ProjectAllocBean.addproj(pObj.getProjectId(), pObj.getProjectName());
			model.addAttribute("projid", pObj.getProjectId());
			model.addAttribute("projname", pObj.getProjectName());
			return "welcome";
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
	public String delete(ModelMap model, @RequestParam(value = "empid", defaultValue = "0") String empid,
			@RequestParam(value = "projid", defaultValue = "0") String projid) {
		ProjectAllocBean.delete(empid, projid);
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
		model.addAttribute("empList", empProjlist);
		return "/view";
	}
}
