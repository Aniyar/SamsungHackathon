package com.hackathon.sic.exception;

public class InstructorNotFoundException extends Exception{
	@Override
	public String getMessage(){
		return "Запрошенного инструктора не существует";
	}
}
