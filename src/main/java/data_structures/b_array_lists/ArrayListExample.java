package data_structures.b_array_lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(){};
        arrayList.add("Stefan");
        arrayList.add("Marto");
        arrayList.add("Zdravko");

        arrayList.remove(arrayList.size() - 1);
        arrayList.remove("Stefan");

        arrayList.get(0);
        arrayList.size();
        arrayList.addAll(
                List.of("Petya", "Roxi"));
        arrayList.contains("Petya");
        arrayList.set(0, "Martin");
        arrayList.indexOf("Roxi");
        arrayList.removeAll(List.of("Petya", "Roxi"));
        arrayList.isEmpty();
        arrayList.clear();
        arrayList.isEmpty();
    }

}
