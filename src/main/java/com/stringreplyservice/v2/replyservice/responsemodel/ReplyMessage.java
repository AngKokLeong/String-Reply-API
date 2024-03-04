package com.stringreplyservice.v2.replyservice.responsemodel;

public class ReplyMessage implements ResponseModel{

	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return message;
	}

}