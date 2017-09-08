import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtclan.ProjectAllocationMVC.entity.Employee;
import com.thoughtclan.ProjectAllocationMVC.entity.Project;
import com.thoughtclan.ProjectAllocationMVC.repository.EmployeeRepository;

public class EmployeeTest {

	@Test
	public void EmployeeCreationTest() {
		Employee employee = new Employee();
		employee.setEmployeeId("10");
		employee.setEmployeeName("Prajwal");
		assertEquals(employee.getEmployeeId(), "10");
	}

	@Test
	public void ComparisionTest() {
		assertEquals(2.0, 2.0, 0);
	}

	@Test
	public void ProjectCreationTest() {
		Project project = new Project();
		project.setProjectId("10");
		project.setProjectName("Java");
		assertEquals(project.getProjectId(), "10");
	}

}
