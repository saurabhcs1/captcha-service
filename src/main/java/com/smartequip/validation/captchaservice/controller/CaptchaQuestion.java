package com.smartequip.validation.captchaservice.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaptchaQuestion {
    private String question;
    private String token;
}
