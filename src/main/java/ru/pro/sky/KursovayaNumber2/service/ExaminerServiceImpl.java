package ru.pro.sky.KursovayaNumber2.service;

import org.springframework.stereotype.Service;
import ru.pro.sky.KursovayaNumber2.dto.Question;
import ru.pro.sky.KursovayaNumber2.exception.ExceededTheNumberOfQuestions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new ExceededTheNumberOfQuestions("У нас нет столько вопросов.");
        }
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }
        return questionSet;
    }
}
