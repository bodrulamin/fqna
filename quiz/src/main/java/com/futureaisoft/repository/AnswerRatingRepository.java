package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futureaisoft.model.AnswerRating;

import java.util.List;

@Repository
public interface AnswerRatingRepository extends JpaRepository<AnswerRating, Long> {
    List<AnswerRating>  findAnswerRatingsByAnswerId(long answerId);
    long countAllByAnswerIdAndIsFavourite(long answerId, boolean isFavourite);
}
