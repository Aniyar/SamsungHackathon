package com.hackathon.sic.exception;

public class InstructorNotAuthorizedException extends Exception {
	@Override
	public String getMessage(){
		return "Инструктор не имеет доступа к запрошенному курсу";
	}
}
