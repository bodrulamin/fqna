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

import com.futureaisoft.model.Question;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/questions")
@CrossOrigin(origins = "*")
public class QuestionController {
    Logger log = LoggerFactory.getLogger(QuestionController.class);

    @Autowired
    private MyService service;

    private final ApiResponse res = MyConstant.apiRes;

    @GetMapping(value = "")
    @Operation(summary = "Get Questions", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<ApiResponse> getQuestions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "0",required = false) Long topicId,
            @RequestParam(defaultValue = "") String query,
            @RequestParam(defaultValue = "id") String orderby,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction
            ) {
        log.info("Starting getQuestion: getQuestions(@RequestParam long page)");
        try {
            System.out.println(topicId);
            List<Question> questions = service.getQuestions(page - 1,size,topicId,query, Sort.by(direction, orderby));
            res.setStatus(MyConstant.SUCCESS);
            res.setMessage("Question loaded successfully ");
            res.setData(questions);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.trace(e.getMessage(), e);
            res.setMessage("Question loading failed! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
    @PostMapping(value = "")
    @Operation(summary = "Save Questions", security = @SecurityRequirement(name = "bearerAuth"))
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
    @GetMapping(value = "{id}")
    @Operation(summary = "Get one Question by id", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<ApiResponse> getQuestion(@PathVariable(value = "id") long id) {
        log.info("Starting getQuestion: getQuestion(@PathVariable(value = \"id\") long id) ");
        try {
            Question question = service.getQuestion(id);
            res.setStatus(MyConstant.SUCCESS);
            res.setMessage("Question loaded successfully ");
            res.setData(question);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.trace(e.getMessage(), e);
            res.setMessage("Question loading failed!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }



    @DeleteMapping(value = "{id}")
    @Operation(summary = "Delete one Question by id", security = @SecurityRequirement(name = "bearerAuth"))
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
