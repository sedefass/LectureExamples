package design_patterns.a_creational.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector instance1 = DatabaseConnector.getInstance();
        System.out.println(instance1.hashCode());

        DatabaseConnector instance2 = DatabaseConnector.getInstance();
        System.out.println(instance2.hashCode());

        System.out.println(instance1.equals(instance2));


        Object obj1 = new Object();
        System.out.println(obj1.hashCode());

        Object obj2 = new Object();
        System.out.println(obj2.hashCode());

        System.out.println(obj1.equals(obj2));
    }
}
