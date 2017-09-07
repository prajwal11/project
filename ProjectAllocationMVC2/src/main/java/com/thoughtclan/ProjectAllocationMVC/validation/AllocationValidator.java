package com.thoughtclan.ProjectAllocationMVC.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.thoughtclan.ProjectAllocationMVC.entity.Employee;

public class AllocationValidator implements Validator{
	
	public boolean supports(Class<?> clazz) {
		if (clazz.equals(Employee.class)) {
			return true;
		}
		return false;
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
	}

	@Override
	public ExecutableValidator forExecutables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDescriptor getConstraintsForClass(Class<?> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validate(T arg0, Class<?>... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(T arg0, String arg1, Class<?>... arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(Class<T> arg0, String arg1, Object arg2, Class<?>... arg3) {
		// TODO Auto-generated method stub
		return null;
	}

}
