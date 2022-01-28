package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
