package com.smartequip.validation.captchaservice.controller;

import com.smartequip.validation.captchaservice.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CaptchaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "GetQuestion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CaptchaQuestion getQuestion() {
        return questionService.getQuestion();
    }

    @RequestMapping(value = "AnswerQuestion", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String answerQuestion(@RequestBody CaptchaAnswer captchaAnswer) {
        questionService.validateQuestion(captchaAnswer);
        questionService.validateAnswer(captchaAnswer);
        return "SUCCESS";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity handle
            (Throwable e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
