package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{



}
