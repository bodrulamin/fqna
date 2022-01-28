package com.futureaisoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.futureaisoft.model.Question;
import com.futureaisoft.repository.QuestionRepository;

@Service
public class MyService {


	private QuestionRepository questionRepository;

	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

	
	public Question getQuestion(Long id) {
		Optional<Question> question = questionRepository.findById(id);
		return question.orElseGet(Question::new);
	}
	

	public void deleteQuestion(Question question) {
		questionRepository.delete(question);
	}
	

	public List<Question> getQuestions(int page) {
		Pageable pageable = PageRequest.of(page, 20);
		Page<Question> questions = questionRepository.findAll(pageable);
		return questions.toList();
	}

}
