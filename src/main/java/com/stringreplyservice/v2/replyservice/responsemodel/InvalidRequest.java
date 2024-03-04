package com.stringreplyservice.v2.replyservice.responsemodel;

public class InvalidRequest implements ResponseModel{
    private final String message;

	public InvalidRequest(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
