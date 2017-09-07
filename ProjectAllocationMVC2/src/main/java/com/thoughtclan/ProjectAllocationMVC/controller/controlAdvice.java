package com.thoughtclan.ProjectAllocationMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class controlAdvice {
	@ExceptionHandler({ Exception.class })
	public String errorHandler() {
		return "error";
	}
	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public String handleBadRequestException(MethodArgumentNotValidException ex) {
        return "error";
    }*/
}
