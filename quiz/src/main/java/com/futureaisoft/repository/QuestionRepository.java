package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
