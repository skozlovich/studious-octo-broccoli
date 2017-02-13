package com.sergey;

import com.sergey.calculator.Calculator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

  @RequestMapping("/calculate")
  public NumberResult calculate(@RequestBody Expression input) {
    Calculator calc = new Calculator();
    Long result = calc.evaluateExpression(input.getExpression());
    return new NumberResult(result);
  }
}
