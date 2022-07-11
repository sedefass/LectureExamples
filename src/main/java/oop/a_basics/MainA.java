package oop.a_basics;

public class MainA {

    public static void main(String[] args) {
        Example example1 = new Example("example1");
        System.out.println("TOTAL EXAMPLES CREATED: " + Example.getTotalCount());

        Example example2 = new Example("example2");
        System.out.println("TOTAL EXAMPLES CREATED: " + Example.getTotalCount());

        System.out.println(example1.getName() + " creation index: " + example1.getCreationIndex());
        System.out.println(example2.getName() + " creation index: " + example2.getCreationIndex());

        new Example();
        System.out.println("TOTAL EXAMPLES CREATED: " + Example.getTotalCount());

        System.out.println(example1.getName() + " creation index: " + example1.getCreationIndex());
        System.out.println(example2.getName() + " creation index: " + example2.getCreationIndex());

//        Example.getCreationIndex();  // calling
        example1.getTotalCount();
    }

}
