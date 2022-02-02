package com.futureaisoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.Vote;

@RestController
@RequestMapping("api/v1/votes")
@CrossOrigin(origins = "*")
public class VoteController {

	Logger log = LoggerFactory.getLogger(Vote.class);
}
