package design_patterns.c_behavioural.interpreter;

import design_patterns.c_behavioural.interpreter.a.InterpreterEngine;
import design_patterns.c_behavioural.interpreter.c.Calculator;

public class Main {


    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InterpreterEngine());

        System.out.println("Result: " + calculator.interpret("add 15 and 25"));
        System.out.println("Result: " + calculator.interpret("multiply " + calculator.interpret("add 5 and 5") + " and 10"));
    }
}