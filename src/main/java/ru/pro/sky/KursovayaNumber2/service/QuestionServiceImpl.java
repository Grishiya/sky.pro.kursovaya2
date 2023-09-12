package ru.pro.sky.KursovayaNumber2.service;

import ru.pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class QuestionServiceImpl implements QuestionService {
    private Map<Integer, Question> questionMap = new HashMap<>();

    public QuestionServiceImpl() {
        this.questionMap = new HashMap<>();
    }
    @Override

    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
