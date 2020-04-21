package design_patterns.c_behavioural.interpreter.b;

import design_patterns.c_behavioural.interpreter.a.Expression;
import design_patterns.c_behavioural.interpreter.a.InterpreterEngine;

public class MultiplyExpression implements Expression {
    private String expression;

    public MultiplyExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public int interpret(InterpreterEngine engine) {
        return engine.multiply(expression);
    }
}