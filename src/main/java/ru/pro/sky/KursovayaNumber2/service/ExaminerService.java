package ru.pro.sky.KursovayaNumber2.service;

import ru.pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
