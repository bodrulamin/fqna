package com.futureaisoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futureaisoft.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
