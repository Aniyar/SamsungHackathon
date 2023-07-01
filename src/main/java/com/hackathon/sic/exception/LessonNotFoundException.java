package com.hackathon.sic.exception;


public class LessonNotFoundException extends Exception{
	@Override
	public String getMessage(){
		return "Запрошенный урок не был найден";
	}
}
