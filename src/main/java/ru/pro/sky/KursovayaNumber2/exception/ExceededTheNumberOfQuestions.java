package ru.pro.sky.KursovayaNumber2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ExceededTheNumberOfQuestions extends RuntimeException{
    public ExceededTheNumberOfQuestions(String message) {
        super(message);
    }
}
