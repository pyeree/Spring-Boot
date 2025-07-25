package com.group.libraryapp.controller.calculator;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import com.group.libraryapp.dto.calculator.response.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController // 바로 아래 클래스를 API의 진입 지점으로 만드는 역할
public class CalculatorController {

    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }
    @PostMapping("/multiply") // POST /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();

    }
    @GetMapping("/api/v1/calc")
    public Calculator calculatorTwoNumbers(@RequestParam int number1, @RequestParam int number2){
       int add = number1 + number2;
       int minus = number1 - number2;
       int multiply = number1 * number2;

       return new Calculator(add,minus,multiply);

    }



}
