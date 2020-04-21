package design_patterns.c_behavioural.mediator;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        Chat.showMessage(this, message);
    }
}