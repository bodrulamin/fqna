package com.futureaisoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.Topic;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/topics")
@CrossOrigin(origins = "*")
public class TopicController {

	Logger log = LoggerFactory.getLogger(TopicController.class);

	@Autowired
	private MyService service;

	private ApiResponse res = MyConstant.apiRes;

	@PostMapping(value = "")
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

	@GetMapping(value = "")
	public ResponseEntity<ApiResponse> getTopics(@RequestParam(defaultValue = "1") int page) {
		log.info("Starting getTopics: getTopics(@RequestParam long page)");
		try {
			List<Topic> topic = service.getTopics(page - 1);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Topic loaded successfully ");
			res.setData(topic);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Topic loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting delete topic: delete(@PathVariable(value = \"id\") Long id)");

		Topic topic = service.getTopic(id);
		try {
			service.deleteTopic(topic);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Topic deleted successfully");
			res.setData(topic);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Topic deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
}
