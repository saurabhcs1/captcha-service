package com.smartequip.validation.captchaservice;

import com.smartequip.validation.captchaservice.service.GetNumbersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CaptchaServiceApplicationTests {

	@Autowired
	GetNumbersService getNumbersService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetNumber(){
		List<Integer> numbers = getNumbersService.getNumbers();
		System.out.println(numbers);
		assert 3 == numbers.size();
	}

}
