package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.QuestionRating;

@Repository
public interface QuestionRatingRepository extends JpaRepository<QuestionRating, Long>{

    long countAllByQuestionIdAndIsFavourite(long questionId,boolean isFavourite);

}
