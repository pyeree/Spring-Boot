package com.group.libraryapp.controller.HW;

import com.group.libraryapp.dto.HW.request.AddNumbersRequest;
import com.group.libraryapp.dto.HW.response.Day2_2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.group.libraryapp.dto.HW.response.Day2;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class Day2Controller {

    @GetMapping("api/v1/calc")
    public Day2 calculatorTwoNumber(@RequestParam int num1, @RequestParam int num2){
        int add = num1 + num2;
        int minus = num1 - num2;
        int multiply = num1 * num2;

        return new Day2(add, minus, multiply);
    }

    @GetMapping("api/v1/day-of-the-week")
    public Day2_2  dayOfTheWeek(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        String dayOfTheWeek = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
        return new Day2_2(dayOfTheWeek);
    }
    @PostMapping("api/v1/add-numbers")
    public int add_numbers(@RequestBody AddNumbersRequest numbers){
        int sum = 0;
        for(int num : numbers.getNumbers()){
            sum += num;
        }
        return sum;
    }

}
