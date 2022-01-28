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

import com.futureaisoft.model.Question;
import com.futureaisoft.model.Topic;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

import antlr.Token;

@RestController
@RequestMapping("api/home")
@CrossOrigin(origins = "*")
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MyService service;
	
	private ApiResponse res = MyConstant.apiRes;
	
	@PostMapping(value = "/topic_save")
	public ResponseEntity<ApiResponse> save(@RequestBody Topic entity) {

		log.info("Starting save: save(@RequestBody Topic entity)");
		try {
			Topic topic = service.saveTopic(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Topic saved successfully");
			res.setData(topic);

			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Topic added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

}
