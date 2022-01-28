package com.futureaisoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.Answer;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/answer")
@CrossOrigin(origins = "*")
public class AnswerController {
	Logger log = LoggerFactory.getLogger(AnswerController.class);
	
	@Autowired
	private MyService service;
	
	private ApiResponse res = MyConstant.apiRes;
	
	@PostMapping(value = "/save")
	public ResponseEntity<ApiResponse> save(@RequestBody Answer entity) {

		log.info("Starting save: save(@RequestBody Answer entity)");
		try {
			Answer answer = service.saveAnswer(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Question saved successfully");
			res.setData(answer);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Question added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
	
}
