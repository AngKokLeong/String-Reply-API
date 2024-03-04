package com.stringreplyservice.v2.replyservice.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stringreplyservice.v2.replyservice.exception.InvalidHashMapKeyIndexException;
import com.stringreplyservice.v2.replyservice.exception.InvalidRequestException;
import com.stringreplyservice.v2.replyservice.responsemodel.EmptyMessage;
import com.stringreplyservice.v2.replyservice.responsemodel.InvalidRequest;
import com.stringreplyservice.v2.replyservice.responsemodel.ReplyMessage;
import com.stringreplyservice.v2.replyservice.responsemodel.ResponseModel;
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
	public ResponseEntity<ResponseModel> replying() {
		return new ResponseEntity<ResponseModel>(new EmptyMessage("Message is empty"), HttpStatus.OK);
	}

	@GetMapping("/reply/{message}")
	public ResponseEntity<ResponseModel> replying(@PathVariable String message) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, Exception {
		try{
			String result = replyMessageProcessor.processMessage(message);

			return new ResponseEntity<ResponseModel>(new ReplyMessage(result), HttpStatus.OK);
		}catch (InvalidRequestException ex){
			return new ResponseEntity<ResponseModel>(new InvalidRequest("Invalid input"), HttpStatus.BAD_REQUEST);
		}catch (NullPointerException ex){
			return new ResponseEntity<ResponseModel>(new InvalidRequest("Invalid input"), HttpStatus.BAD_REQUEST);
		}catch (InvalidHashMapKeyIndexException ex) {
			return new ResponseEntity<ResponseModel>(new InvalidRequest("Invalid input"), HttpStatus.BAD_REQUEST);
		}
	}
}    

