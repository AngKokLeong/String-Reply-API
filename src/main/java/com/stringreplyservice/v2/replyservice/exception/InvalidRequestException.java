package com.stringreplyservice.v2.replyservice.exception;

public class InvalidRequestException extends RuntimeException{

    private final String message;

    public InvalidRequestException(String message){
        this.message = message;
    }

	public String getMessage() {
		return message;
	}
}
