package design_patterns.c_behavioural.interpreter.b;

import design_patterns.c_behavioural.interpreter.a.Expression;
import design_patterns.c_behavioural.interpreter.a.InterpreterEngine;

public class AddExpression implements Expression {
    private String expression;

    public AddExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngine engine) {
        return engine.add(expression);
    }
}