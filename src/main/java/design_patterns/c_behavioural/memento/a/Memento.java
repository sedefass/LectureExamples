package design_patterns.c_behavioural.memento.a;

public class Memento {
    private String state;  // Wee keep whatever state we need

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}