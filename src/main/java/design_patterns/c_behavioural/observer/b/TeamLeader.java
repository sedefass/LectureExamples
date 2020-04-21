package design_patterns.c_behavioural.observer.b;

import design_patterns.c_behavioural.observer.a.Observer;
import design_patterns.c_behavioural.observer.a.Programmer;

public class TeamLeader extends Observer {

    public TeamLeader(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }

    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Successful")) {
            System.out.println("Team Leader is proud of his Programmer.");
        } else {
            System.out.println("Team Leader is not proud of his Programmer.");
        }
    }
}