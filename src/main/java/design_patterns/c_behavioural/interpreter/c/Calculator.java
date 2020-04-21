package design_patterns.c_behavioural.interpreter.c;

import design_patterns.c_behavioural.interpreter.a.Expression;
import design_patterns.c_behavioural.interpreter.a.InterpreterEngine;
import design_patterns.c_behavioural.interpreter.b.AddExpression;
import design_patterns.c_behavioural.interpreter.b.MultiplyExpression;

public class Calculator {
    private InterpreterEngine engine;

    public Calculator(InterpreterEngine engine) {
        this.engine = engine;
    }

    public int interpret(String input) {
        Expression expression = null;

        if (input.contains("add")) {
            expression = new AddExpression(input);
        } else if (input.contains("multiply")) {
            expression = new MultiplyExpression(input);
        }

        int result = expression.interpret(engine);
        System.out.println(input);
        return result;
    }

}
