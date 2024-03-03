package com.stringreplyservice.v2.replyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stringreplyservice.v2.replyservice.model.ReplyMessage;
import com.stringreplyservice.v2.replyservice.service.ReplyMessageProcessor;


@RestController
@RequestMapping("/v2")
public class ReplyController_v2 {

	private ReplyMessageProcessor replyMessageProcessor;

	@Autowired
	public ReplyController_v2(ReplyMessageProcessor replyMessageProcessor){
		this.replyMessageProcessor = replyMessageProcessor;
	}

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}
}    

