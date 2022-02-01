package com.futureaisoft.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

import com.futureaisoft.model.AnswerRating;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/answerRatings")
@CrossOrigin(origins = "*")
public class AnswerRatingController {

	Logger log = LoggerFactory.getLogger(AnswerRatingController.class);

	@Autowired
	private MyService service;

	private final ApiResponse res = MyConstant.apiRes;

	@GetMapping(value = "")
	@Operation(summary = "Get AnswerRatings", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<ApiResponse> getAnswerRatings(@RequestParam long answerId) {
		log.info("Starting getAnswerRatings: getAnswerRatings(@RequestParam long page)");
		try {
			List<AnswerRating> answerRating = service.getAnswerRatings(answerId);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("AnswerRating loaded successfully ");
			res.setData(answerRating);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("AnswerRating loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<ApiResponse> save(@RequestBody AnswerRating entity) {

		log.info("Starting save: save(@RequestBody AnswerRating entity)");
		try {
			AnswerRating answerRating = service.saveAnswerRatings(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("AnswerRating saved successfully");
			res.setData(answerRating);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("AnswerRating added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
	
	@GetMapping(value = "{id}")
    public ResponseEntity<ApiResponse> getAnswerRating(@PathVariable(value = "id") long id) {
        log.info("Starting getAnswerRating: getAnswerRating(@PathVariable(value = \"id\") long id) ");
        try {
        	AnswerRating answerRating = service.getAnswerRating(id);
            res.setStatus(MyConstant.SUCCESS);
            res.setMessage("AnswerRating loaded successfully ");
            res.setData(answerRating);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.trace(e.getMessage(), e);
            res.setMessage("AnswerRating loading failed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting AnswerRatingtDelete: delete(@PathVariable(value = \"id\") Long id)");

		AnswerRating answerRating = service.getAnswerRating(id);
		try {
			service.deleteAnswerRating(answerRating);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("AnswerRating deleted successfully");
			res.setData(answerRating);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("AnswerRating deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
}
