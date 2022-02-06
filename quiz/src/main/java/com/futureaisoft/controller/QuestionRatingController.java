package com.futureaisoft.controller;

import com.futureaisoft.model.RatingCount;
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

import com.futureaisoft.model.QuestionRating;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/question-ratings")
@CrossOrigin(origins = "*")
public class QuestionRatingController {

	Logger log = LoggerFactory.getLogger(QuestionRatingController.class);

	@Autowired
	private MyService service;

	private final ApiResponse res = MyConstant.apiRes;


	@GetMapping("/count")
	@Operation(summary = "Get Rating Count", security = @SecurityRequirement(name = "bearerAuth"))

	public ResponseEntity<?> getRatingCount(@RequestParam long questionId) {
		log.info("Starting getRatingCount: getRatingCount(@RequestParam long questionId)");
		try {
			RatingCount ratingCount = service.getQuestionRatingCount(questionId);

			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("Question RatingCount loaded successfully ");
			res.setData(ratingCount);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("QuestionRating loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@PostMapping
	@Operation(summary = "Save Rating Count", security = @SecurityRequirement(name = "bearerAuth"))

	public ResponseEntity<?> save(@RequestBody QuestionRating entity) {

		log.info("Starting save: save(@RequestBody QuestionRating entity)");
		try {
			QuestionRating questionRating = service.saveQuestionRatings(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("QuestionRating saved successfully");
			res.setData(questionRating);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("QuestionRating added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
	
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "Get Rating by rating id", security = @SecurityRequirement(name = "bearerAuth"))
	public ResponseEntity<?> getQuestionRating(@PathVariable(value = "id") long id) {
        log.info("Starting getQuestionRating: getQuestionRating(@PathVariable(value = \"id\") long id) ");
        try {
        	QuestionRating questionRating = service.getQuestionRatingById(id);
            res.setStatus(MyConstant.SUCCESS);
            res.setMessage("QuestionRating loaded successfully ");
            res.setData(questionRating);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.trace(e.getMessage(), e);
            res.setMessage("QuestionRating loading failed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
	
	
	

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting QuestionRatingtDelete: delete(@PathVariable(value = \"id\") Long id)");

		QuestionRating questionRating = service.getQuestionRatingById(id);
		try {
			service.deleteQuestionRating(questionRating);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("QuestionRating deleted successfully");
			res.setData(questionRating);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("QuestionRating deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
}
