package com.futureaisoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.Question;
import com.futureaisoft.repository.QuestionRepository;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/question")
@CrossOrigin(origins = "*")
public class QuestionController {
	Logger log = LoggerFactory.getLogger(QuestionController.class);


	private MyService service;

	private ApiResponse res = MyConstant.apiRes;

	@GetMapping(value = "")
	public ResponseEntity<ApiResponse> getQuestions(@RequestParam(defaultValue = "1") int page ) {
		log.info("Starting getQuestion: getQuestions(@RequestParam long page)");
		//System.out.println(page);
		try {
			List<Question> questions = service.getQuestions(page-1);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Question loaded successfully ");
			res.setData(questions);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Question loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}


	@PostMapping(value = "/save")
	public ResponseEntity<ApiResponse> save(@RequestBody Question entity) {

		log.info("Starting save: save(@RequestBody Question entity)");
		try {
			Question question = service.saveQuestion(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Question saved successfully");
			res.setData(question);

			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Question added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting delete: delete(@PathVariable(value = \"id\") Long id)");

		Question question = service.getQuestion(id);
		try {
			service.deleteQuestion(question);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Question deleted successfully");
			res.setData(question);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Question deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

}
