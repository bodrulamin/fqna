package com.futureaisoft.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

    Page<Question> getQuestionByTopicId(long topicId, Pageable pageable);
    Page<Question> getQuestionByTopicIdAndQuestionContaining(long topicId, String word, Pageable pageable);
    Page<Question> findByQuestionContaining(String word, Pageable pageable);




}
