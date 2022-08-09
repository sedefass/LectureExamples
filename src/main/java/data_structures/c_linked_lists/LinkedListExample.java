package data_structures.c_linked_lists;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Asen");
        linkedList.add("Boyan");
        linkedList.add("Chavdar");
        linkedList.add("Daniela");
        linkedList.add("Elena");
        linkedList.add("Filip");
        linkedList.add("Georgi");
        linkedList.add("Hristo");

        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(1);
        linkedList.remove("Filip");

        linkedList.addFirst("Stefan");
        linkedList.add(1, "Martin");
        linkedList.addLast("Zdravko");
    }

}
