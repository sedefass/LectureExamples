package design_patterns.a_creational.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector instance1 = DatabaseConnector.getInstance();
        instance1.showMessage();

        DatabaseConnector instance2 = DatabaseConnector.getInstance();
        instance2.showMessage();

        System.out.println(instance1.equals(instance2));
    }
}
