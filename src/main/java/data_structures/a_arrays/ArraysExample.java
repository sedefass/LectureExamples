package data_structures.a_arrays;

import java.util.Arrays;

public class ArraysExample {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4};

        // traverse
        System.out.println("array content:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // Add item to an array
        // other ways are possible such as Arrays.copyOf
        // or using new ArrayList -> .add -> .toArray
        int extended[] = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            extended[i] = array[i];
        }

        extended[extended.length - 1] = 5;

        // Stream API
        System.out.println("extended content:");
        Arrays.stream(extended)
                .forEach(System.out::println);
    }

}
