package com.example.kns.services;

import com.example.kns.models.*;
import com.example.kns.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final QuestionsAnswerRepository questionsAnswerRepository;
    private final QuestionsResultRepository questionsResultRepository;
    public List<Test> listTests() {
        return testRepository.findAll();
    }


    public List<Question> findQuestionByIdTest(Long idTest) {
        List<Question> newList = new ArrayList<>();
        for (Question question: questionRepository.findAll()) {
            if(question.getTest().getId().equals(idTest)){
                newList.add(question);
            }
        }
        return newList;
    }
    public List<Question> listQuestions(Long idTest) {
        List<Question> list = findQuestionByIdTest(idTest);
        Comparator<Question> compareByNamber = new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o1.getNamber()-o2.getNamber();
            }
        };
        Collections.sort(list, compareByNamber);
        return list;
    }

    public Test getTestById(Long idTest) {
        return testRepository.findById(idTest).orElse(null);
    }

    public List<QuestionsResult> listResult(Long idTest) {
        List<QuestionsResult> list = findQuestionResultByIdTest(idTest);
        Comparator<QuestionsResult> compareByNamber = new Comparator<QuestionsResult>() {
            @Override
            public int compare(QuestionsResult o1, QuestionsResult o2) {
                return o1.getMin()- o1.getMin();
            }
        };
        Collections.sort(list, compareByNamber);
        return list;
    }

    private List<QuestionsResult> findQuestionResultByIdTest(Long idTest) {
        List<QuestionsResult> newList = new ArrayList<>();
        for (QuestionsResult result: questionsResultRepository.findAll()) {
            if(result.getTest().getId().equals(idTest)){
                newList.add(result);
            }
        }
        return newList;
    }
}
//    public void addTest(Test test){
//        testRepository.save(test);
//    }
//    public void addQuestions(Test test, Question question){
//        question.setTest(test);
//        test.addQuestionToTest(question);
//        testRepository.save(test);
//        questionRepository.save(question);
//    }
//    public void addQuestionsAnswer(Question question, QuestionsAnswer questionsAnswer){
//        questionsAnswer.setQuestion(question);
//        question.addQuestionAnswer(questionsAnswer);
//        questionRepository.save(question);
//        questionsAnswerRepository.save(questionsAnswer);
//    }
//
//    public void addResult(Test test, QuestionsResult result){
//        result.setTest(test);
//        test.addResultToTest(result);
//        testRepository.save(test);
//        questionsResultRepository.save(result);
//    }
