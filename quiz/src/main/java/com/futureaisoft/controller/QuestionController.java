package com.futureaisoft.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.Question;
import com.futureaisoft.service.QuestionService;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping(value = "/question/save")
	public ResponseEntity<?> save(@RequestBody Question entity) {
		Map<String, Object> map = new HashMap<>();
		try {
			Question question = questionService.save(entity);
			map.put("message", "Data save successfully");
			map.put("data", question);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data saved failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
	@GetMapping(value = "/question/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		Map<String, Object> map = new HashMap<>();
		Question question = questionService.findById(id).get();
		try {
			questionService.delete(question);
			map.put("message", "Data deleted successfully");
			map.put("data", question);
			map.put("statusCode", 200);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("message", "Data deletation failed");
			map.put("data", null);
			map.put("statusCode", 400);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
		}
	}
	
	
}
