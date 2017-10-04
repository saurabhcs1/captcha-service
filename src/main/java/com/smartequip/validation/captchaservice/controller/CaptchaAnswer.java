package com.smartequip.validation.captchaservice.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaptchaAnswer extends CaptchaQuestion{
    private int answer;
}
