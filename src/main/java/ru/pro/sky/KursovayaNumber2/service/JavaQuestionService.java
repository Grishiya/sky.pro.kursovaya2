package ru.pro.sky.KursovayaNumber2.service;

import ru.pro.sky.KursovayaNumber2.dto.Question;

import java.util.*;

public class JavaQuestionService implements QuestionService {
    private List<Question> questionList;
    private final Random random;

    public JavaQuestionService() {
        this.questionList = new ArrayList<>();
        random = new Random();
    }

    @Override

    public Question add(String question, String answer) {
        Question newQuestionAndAnswer = new Question(question, answer);
        add(newQuestionAndAnswer);
        return newQuestionAndAnswer;
    }

    @Override
    public Question add(Question question) {
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        return questionList.get(random.nextInt(questionList.size()));
    }
}
