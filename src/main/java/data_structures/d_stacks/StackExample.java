package data_structures.d_stacks;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.peek();
        stack.pop();
        stack.isEmpty();


    }

}
