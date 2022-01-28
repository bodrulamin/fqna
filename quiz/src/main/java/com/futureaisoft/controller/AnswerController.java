package com.futureaisoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ApiResponse res = MyConstant.apiRes;

    @PostMapping(value = "")
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

    @GetMapping(value = "")
    public ResponseEntity<ApiResponse> getAnswers(@RequestParam(defaultValue = "1") int page) {
        log.info("Starting getAnswers: getAnswers(@RequestParam long page)");
        try {
            List<Answer> answers = service.getAnswers(page - 1);
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

    @GetMapping(value = "/delete/{id}")
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
