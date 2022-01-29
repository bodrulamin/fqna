package com.futureaisoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.futureaisoft.model.Answer;
import com.futureaisoft.model.Question;
import com.futureaisoft.model.Topic;
import com.futureaisoft.repository.AnswerRepository;
import com.futureaisoft.repository.QuestionRepository;
import com.futureaisoft.repository.TopicRepository;

@Service
public class MyService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private TopicRepository topicRepository;

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

	public Answer saveAnswer(Answer answer) {
		return answerRepository.save(answer);
	}

	public Answer getAnswer(Long id) {
		Optional<Answer> answer = answerRepository.findById(id);
		return answer.orElseGet(Answer::new);
	}

	public void deleteAnswer(Answer answer) {
		answerRepository.delete(answer);
	}

	public List<Answer> getAnswers(int page) {
		Pageable pageable = PageRequest.of(page, 20);
		Page<Answer> answers = answerRepository.findAll(pageable);
		return answers.toList();
	}

	public Topic saveTopic(Topic topic) {
		return topicRepository.save(topic);
	}

	public List<Topic> getTopics(int page) {
		Pageable pageable = PageRequest.of(page, 20);
		Page<Topic> topic = topicRepository.findAll(pageable);
		return topic.toList();
	}

	public Topic getTopic(Long id) {
		Optional<Topic> topic = topicRepository.findById(id);
		return topic.orElseGet(Topic::new);
	}

	public void deleteTopic(Topic topic) {
		topicRepository.delete(topic);
	}

}
