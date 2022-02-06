package com.futureaisoft.service;

import com.futureaisoft.model.*;
import com.futureaisoft.repository.*;
import com.futureaisoft.model.RatingCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TopicRepository topicRepository;
    private final PointChartRepository pointChartRepository;
    private final QuestionRatingRepository questionRatingRepository;
    private final AnswerRatingRepository answerRatingRepository;
    private RatingCount ratingCount;
    @Autowired
    public MyService(QuestionRepository questionRepository,
                     AnswerRepository answerRepository,
                     TopicRepository topicRepository,
                     PointChartRepository pointChartRepository,
                     QuestionRatingRepository questionRatingRepository,
                     AnswerRatingRepository answerRatingRepository,
                     RatingCount ratingCount) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.topicRepository = topicRepository;
        this.pointChartRepository = pointChartRepository;
        this.questionRatingRepository = questionRatingRepository;
        this.answerRatingRepository = answerRatingRepository;
        this.ratingCount = ratingCount;
    }

    public Question saveQuestion(Question question)  {
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

            questions = questionRepository.findByQuestionContaining(query, pageable);

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

    public List<QuestionRating> getQuestionRatingById(int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<QuestionRating> questionRating = questionRatingRepository.findAll(pageable);
        return questionRating.toList();
    }

    public QuestionRating getQuestionRatingById(Long id) {
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

    public RatingCount getQuestionRatingCount(Long questionId) {
       long positive = questionRatingRepository.countAllByQuestionIdAndIsFavourite(questionId,true);
       long negative = questionRatingRepository.countAllByQuestionIdAndIsFavourite(questionId,false);
        ratingCount = new RatingCount(questionId,positive,negative);
        return ratingCount;
    }
}
