package com.stringreplyservice.v2.replyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException{

    private final String message;

    public InvalidRequestException(String message){
        this.message = message;
    }

	public String getMessage() {
		return message;
	}
}
