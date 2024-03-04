package com.stringreplyservice.v2.replyservice.exception;

public class InvalidHashMapKeyIndexException extends Exception{
    private final String message;

    public InvalidHashMapKeyIndexException(String message){
        this.message = message;
    }

	public String getMessage() {
		return message;
	}
}
