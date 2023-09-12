package ru.pro.sky.KursovayaNumber2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.pro.sky.KursovayaNumber2.dto.Question;
import ru.pro.sky.KursovayaNumber2.exception.ExceededTheNumberOfQuestions;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question = new Question(
            "Что такое массив?",
            "Массив — это структура данных," +
                    " которая позволяет хранить несколько значений одного типа.");
    Question question2 = new Question("В чем разница между == и equals()?",
            "== сравнивает между собой значения примитивов,или равные ссылки объектов." +
                    "equals сравнивает сами объекты ");
    Collection<Question> allQuestion = new ArrayList<>(List.of(question, question2));

    @Test
    void getQuestions_checkQuestionGetQuestionsInCollection_returnedGetQuestions() {
        when(javaQuestionService.getAll()).thenReturn(allQuestion);
        Collection<Question> result = underTest.getQuestions(2);
        assertEquals(allQuestion,result);
    }

    @Test
    void getQuestions_theNumberOfDesiredQuestionsExceedsTheSizeOfTheQuestions_thrownMaxSizeAmountQuestion() {
        when(javaQuestionService.getAll()).thenReturn(Collections.emptySet());
        ExceededTheNumberOfQuestions exc = assertThrows(
                ExceededTheNumberOfQuestions.class,
                () -> underTest.getQuestions(3));
        assertEquals("У нас нет столько вопросов.", exc.getMessage());
    }
}