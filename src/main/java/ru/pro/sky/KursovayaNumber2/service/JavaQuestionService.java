package ru.pro.sky.KursovayaNumber2.service;

import org.springframework.stereotype.Service;
import ru.pro.sky.KursovayaNumber2.dto.Question;

import java.util.*;
@Service

public class JavaQuestionService implements QuestionService {
    private Set<Question> questionSet;
    private final Random random;

    public JavaQuestionService() {
        this.questionSet = new HashSet<>();
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
        questionSet.add(question);


        return question;
    }

    @Override
    public Question remove(Question question) {
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }

    @Override
    public Question getRandomQuestion() {
        return questionSet.toArray(Question[]::new)[
                random.nextInt(questionSet.size())];
    }
}
