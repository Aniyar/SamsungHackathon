package com.hackathon.sic.exception;

public class StudentNotFoundException extends Exception{
	@Override
	public String getMessage(){
		return "Запрошенного студента не существует";
	}
}
