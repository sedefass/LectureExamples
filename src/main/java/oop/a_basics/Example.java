package oop.a_basics;

public class Example {

    // STATIC FIELDS
    private static int totalCount = 0;

    // Show difference between those two
    public static final int SALARY = 500;
    public final int salary = 500;

    // FIELDS
    private String name;
    private int creationIndex;

    // CONSTRUCTORS - called with `new` word
    public Example() {
        totalCount++;
        this.creationIndex = totalCount;
    }

    public Example(String name) {
        this.name = name;
        totalCount++;
        this.creationIndex = totalCount;
    }

    // SETTERS & GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public int getCreationIndex() {
        return creationIndex;
    }


    // INSTANCE METHODS
    public void extendExample(Example updatingExample) {
        this.name = this.name + generateUpdaterSymbol() + updatingExample.getName();
    }

    private String generateUpdaterSymbol() {
        if (totalCount < 10) { return "^"; }
        if (totalCount < 50) { return "#"; }
        if (totalCount < 100) { return "*"; }
        return "&";
    }

    // STATIC METHODS
    public static Example unifyExamples(Example example1, Example example2) {
        return new Example(example1.getName() + " " + example2.getName());
    }
}
