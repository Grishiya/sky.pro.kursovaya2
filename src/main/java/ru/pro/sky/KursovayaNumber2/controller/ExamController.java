package ru.pro.sky.KursovayaNumber2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pro.sky.KursovayaNumber2.dto.Question;
import ru.pro.sky.KursovayaNumber2.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {
    final private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getQuestions(
            @RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
