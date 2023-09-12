package ru.pro.sky.KursovayaNumber2.service;

import org.junit.jupiter.api.Test;
import ru.pro.sky.KursovayaNumber2.dto.Question;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService undetTest = new JavaQuestionService();
    Question question = new Question(
            "Что такое массив?",
            "Массив — это структура данных," +
                    " которая позволяет хранить несколько значений одного типа.");
    Question question2 = new Question("В чем разница между == и equals()?",
            "== сравнивает между собой значения примитивов,или равные ссылки объектов." +
                    "equals сравнивает сами объекты ");
    Collection<Question> allQuestion = new HashSet<>(List.of(question, question2));

    @Test
    void add_checkAdditionalAnQuestion_returnedQuestion() {
        Question result = undetTest.add(question);
        assertEquals(question, result);
    }

    @Test
    void add_checkAdditionalAnQuestionAndAnswer_returnedQuestionAndAnswer() {
        Question result = undetTest.add
                ("Что такое массив?",
                        "Массив — это структура данных," +
                                " которая позволяет хранить несколько значений одного типа.");
        assertEquals(question, result);
    }

    @Test
    void remove_checkRemovedQuestion_questionRemovedAndReturned() {
        Question result = undetTest.remove(question);
        assertEquals(question, result);
    }

    @Test
    void getAll_checkGetAllInCollection_returnedGetAll() {
        undetTest.add(question);
        undetTest.add(question2);
        Collection<Question> result = undetTest.getAll();
        assertTrue(result.containsAll(allQuestion));
    }
}