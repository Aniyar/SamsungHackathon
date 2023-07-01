package com.hackathon.sic.exception;

public class CourseNotFoundException extends Exception {
	@Override
	public String getMessage(){
		return "Запрошенного курса не существует";
	}
}
