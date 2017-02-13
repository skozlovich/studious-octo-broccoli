package com.sergey.calculator;

public enum Operator {
  ADDITION("+", 1),
  SUBTRACTION("-", 1),
  MULTIPLICATION("*", 2),
  DIVISION("/", 2);
  //Extensible to include new operators

  private final String op;
  private final int priority;

  Operator(String op, int priority) {
    this.op = op;
    this.priority = priority;
  }

  public static Operator fromChar(char value) {
    Operator result = null;
    switch (value) {
      case '+':
        result = ADDITION;
        break;
      case '-':
        result = SUBTRACTION;
        break;
      case '*':
        result = MULTIPLICATION;
        break;
      case '/':
        result = DIVISION;
        break;
    }

    return result;
  }

  public String getOp() {
    return op;
  }

  public int getPriority() {
    return priority;
  }
}
