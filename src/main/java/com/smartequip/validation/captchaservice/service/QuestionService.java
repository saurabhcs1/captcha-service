package com.smartequip.validation.captchaservice.service;

import com.smartequip.validation.captchaservice.controller.CaptchaAnswer;
import com.smartequip.validation.captchaservice.controller.CaptchaQuestion;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionService {

    @Autowired
    GetNumbersService getNumbersService;

    @Autowired
    StringEncryptor stringEncryptor;

    private String getQuestionString(){
        StringBuilder question = new StringBuilder("Please sum the numbers ");
        int i = 0;
        for(Integer number : getNumbersService.getNumbers()){
            if(i > 0){
                question.append(",");
            }

            question.append(number);
            i ++;
        }

        return question.toString();
    }

    public CaptchaQuestion getQuestion(){
        CaptchaQuestion question = new CaptchaQuestion();
        question.setQuestion(getQuestionString());
        question.setToken(stringEncryptor.encrypt(question.getQuestion()));
        return question;
    }

    public void validateQuestion(CaptchaQuestion captchaQuestion){

        if(captchaQuestion.getQuestion() == null || captchaQuestion.getQuestion().trim().length() == 0){
            throw new IllegalArgumentException("Question is null or empty");
        }

        if(captchaQuestion.getToken() == null || captchaQuestion.getToken().trim().length() == 0){
            throw new IllegalArgumentException("Token is null or empty");
        }

        String originalQuestion = null;

        try {
            originalQuestion = stringEncryptor.decrypt(captchaQuestion.getToken());
        }catch (Exception e){
            throw new IllegalArgumentException("Wrong token");
        }

        if(!captchaQuestion.getQuestion().equalsIgnoreCase(originalQuestion)){
            throw new IllegalArgumentException("Wrong input");
        }
    }

    public void validateAnswer(CaptchaAnswer captchaQuestion){
        String originalQuestion = stringEncryptor.decrypt(captchaQuestion.getToken());
        String[] split = originalQuestion.split(" ");
        String numberString = split[split.length -1];
        String[] numbers = numberString.split(",");

        int answer = 0;
        for(String number : numbers){
            answer = answer + Integer.parseInt(number);
        }

        if(answer != captchaQuestion.getAnswer()){
            throw new IllegalArgumentException("Wrong Answer, Please try again");
        }
    }
}
