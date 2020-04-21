package design_patterns.c_behavioural.mediator;

public class Main {
    public static void main(String[] args) {
        User david = new User("David");
        User scott = new User("Scott");

        david.sendMessage("Hi Scott! How are you?");
        scott.sendMessage("I'm great! Thanks for asking. How are you?");
    }
}