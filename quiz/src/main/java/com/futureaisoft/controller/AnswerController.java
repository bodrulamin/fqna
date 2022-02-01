package com.futureaisoft.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

import com.futureaisoft.model.Answer;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/answers")
@CrossOrigin(origins = "*")
public class AnswerController {
	Logger log = LoggerFactory.getLogger(AnswerController.class);

	@Autowired
	private MyService service;
	


	private final ApiResponse res = MyConstant.apiRes;

	@GetMapping(value = "")
	@Operation(summary = "Get Answers", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ApiResponse> getAnswers(
			@RequestParam long questionId,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "") String q,
			@RequestParam(defaultValue = "id") String orderby,
			@RequestParam(defaultValue = "ASC") Sort.Direction direction
	) {
		log.info("Starting getAnswers: getAnswers(@RequestParam long page)");
		try {
			List<Answer> answers = service.getAnswers(questionId,page - 1, size, q, Sort.by(direction, orderby));
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Answer loaded successfully ");
			res.setData(answers);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Answer loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@PostMapping(value = "")
	@Operation(summary = "Save Answer", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ApiResponse> save(@RequestBody Answer entity) {

		log.info("Starting save: save(@RequestBody Answer entity)");
		try {
			Answer answer = service.saveAnswer(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Answer saved successfully");
			res.setData(answer);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Answer added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	
    @GetMapping(value = "{id}")
	@Operation(summary = "Get one Answer", security = @SecurityRequirement(name = "bearerAuth"))

	public ResponseEntity<ApiResponse> getAnswer(@PathVariable(value = "id") long id) {
        log.info("Starting getAnswer: getAnswer(@PathVariable(value = \"id\") long id) ");
        try {
            Answer answer = service.getAnswer(id);
            res.setStatus(MyConstant.SUCCESS);
            res.setMessage("Answer loaded successfully ");
            res.setData(answer);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.trace(e.getMessage(), e);
            res.setMessage("Answer loading failed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    
	@DeleteMapping(value = "{id}")
	@Operation(summary = "Delete Answer by answerId", security = @SecurityRequirement(name = "bearerAuth"))

	public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting delete: delete(@PathVariable(value = \"id\") Long id)");

		Answer answer = service.getAnswer(id);
		try {
			service.deleteAnswer(answer);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Answer deleted successfully");
			res.setData(answer);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("Answer deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

}
