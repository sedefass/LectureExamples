package design_patterns.a_creational.singleton;

public class DatabaseConnector {

    private static DatabaseConnector instance = new DatabaseConnector();

    private DatabaseConnector() {}

    public static DatabaseConnector getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("I'm a singleton object!");
    }
}