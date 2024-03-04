package com.stringreplyservice.v2.replyservice.responsemodel;

public class EmptyMessage implements ResponseModel{
    private final String message;

	public EmptyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
