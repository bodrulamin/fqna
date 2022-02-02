package com.futureaisoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.futureaisoft.model.Answer;
import com.futureaisoft.model.AnswerRating;
import com.futureaisoft.model.PointChart;
import com.futureaisoft.model.Question;
import com.futureaisoft.model.QuestionRating;
import com.futureaisoft.model.Topic;
import com.futureaisoft.repository.AnswerRatingRepository;
import com.futureaisoft.repository.AnswerRepository;
import com.futureaisoft.repository.PointChartRepository;
import com.futureaisoft.repository.QuestionRatingRepository;
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

    @Autowired
    private PointChartRepository pointChartRepository;

    @Autowired
    private QuestionRatingRepository questionRatingRepository;

    @Autowired
    private AnswerRatingRepository answerRatingRepository;

    public Question saveQuestion(Question question) throws Exception {
        question = questionRepository.save(question);
        return question;
    }

    public Question getQuestion(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        return question.orElseGet(Question::new);
    }

    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public List<Question> getQuestions(int page, int size, long topicId, String query, Sort sortby) {
        Pageable pageable = PageRequest.of(page, size, sortby);

        Page<Question> questions;
        if (topicId == 0) {

            questions = questionRepository.findByQuestionContaining(query,pageable);

        } else {
            questions = questionRepository.getQuestionByTopicIdAndQuestionContaining(topicId, query, pageable);
        }


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

    public List<Answer> getAnswers(long questionId, int page, int size, String q, Sort sortby) {
        Pageable pageable = PageRequest.of(page, size, sortby);

        Page<Answer> answers = answerRepository.findAnswersByQuestionId(questionId, pageable);
        return answers.toList();
    }

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getTopics() {

        return topicRepository.findAll();
    }

    public Topic getTopic(Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.orElseGet(Topic::new);
    }

    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }

    public PointChart savePointChart(PointChart pointChart) {
        return pointChartRepository.save(pointChart);
    }

    public List<PointChart> getPointCharts() {
        return pointChartRepository.findAll();
    }

    public PointChart getPointChart(Long id) {
        Optional<PointChart> pointChart = pointChartRepository.findById(id);
        return pointChart.orElseGet(PointChart::new);
    }

    public void deletePointChart(PointChart pointChart) {
        pointChartRepository.delete(pointChart);
    }

    public QuestionRating saveQuestionRatings(QuestionRating questionRating) {
        return questionRatingRepository.save(questionRating);
    }

    public List<QuestionRating> getQuestionRatings(int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<QuestionRating> questionRating = questionRatingRepository.findAll(pageable);
        return questionRating.toList();
    }

    public QuestionRating getQuestionRatings(Long id) {
        Optional<QuestionRating> questionRating = questionRatingRepository.findById(id);
        return questionRating.orElseGet(QuestionRating::new);
    }

    public void deleteQuestionRating(QuestionRating questionRating) {
        questionRatingRepository.delete(questionRating);
    }

    public AnswerRating saveAnswerRatings(AnswerRating answerRating) {
        return answerRatingRepository.save(answerRating);
    }

    public List<AnswerRating> getAnswerRatings(long answerId) {

        return answerRatingRepository.findAnswerRatingsByAnswerId(answerId);
    }
    public List<AnswerRating> getAnswerRatingsCount(long answerId) {

        return answerRatingRepository.findAnswerRatingsByAnswerId(answerId);
    }
    public AnswerRating getAnswerRating(Long id) {
        Optional<AnswerRating> answerRating = answerRatingRepository.findById(id);
        return answerRating.orElseGet(AnswerRating::new);
    }

    public void deleteAnswerRating(AnswerRating answerRating) {
        answerRatingRepository.delete(answerRating);
    }
}
