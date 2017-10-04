package com.smartequip.validation.captchaservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class GetNumbersService {

    final List<Integer> numbersToUse = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public List<Integer> getNumbers(){
        List<Integer> numbers = new ArrayList<>(numbersToUse);
        Collections.shuffle(numbers);
        IntStream.range(0, numbers.get(0)).mapToObj(i -> numbers).forEach(Collections::shuffle);
        return numbers.subList(0, 3);
    }
}
