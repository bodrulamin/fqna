package com.futureaisoft.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futureaisoft.model.Question;

public interface QuestionService extends JpaRepository<Question, Long>{

}
