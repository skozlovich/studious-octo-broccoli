package com.sergey.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
  private Deque<Long> operands;
  private Deque<Operator> operators;

  public Long evaluateExpression(String expression) {
    operands = new ArrayDeque<>();
    operators = new ArrayDeque<>();

    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (Character.isDigit(c)) {
        operands.push((long) Character.getNumericValue(c));
      } else if (Operator.fromChar(c) != null){
        Operator op = Operator.fromChar(c);
        if (operators.isEmpty() || operators.peek() != null && greaterPriority(op, operators.peek())){
          operators.push(Operator.fromChar(c));
        } else {
          operands.push(calculate(op));
        }
      } else {
        throw new UnsupportedOperationException("Unsupported character supplied in expression: " + c);
      }
    }

    operands.push(calculate(operators.pop()));

    return operands.pop();
  }

  private Long calculate(Operator operator) {
    Long secondOperand = operands.pop();
    Long firstOperand = operands.pop();
    Long result = null;

    switch (operator) {
      case ADDITION:
        result = firstOperand + secondOperand;
        break;
      case SUBTRACTION:
        result = firstOperand - secondOperand;
        break;
      case MULTIPLICATION:
        result = firstOperand * secondOperand;
        break;
      case DIVISION:
        result = firstOperand / secondOperand;
        break;
    }

    return result;
  }

  private static boolean greaterPriority(Operator current, Operator previous) {
    return current.getPriority() > previous.getPriority();
  }
}
