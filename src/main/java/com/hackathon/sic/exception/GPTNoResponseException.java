package com.hackathon.sic.exception;

public class GPTNoResponseException extends Exception {
	@Override
	public String getMessage(){
		return "GPT did not return response";
	}
}
