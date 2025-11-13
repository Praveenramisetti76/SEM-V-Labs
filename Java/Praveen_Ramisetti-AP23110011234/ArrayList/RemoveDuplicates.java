import java.util.*;

public class RemoveDuplicates {
    public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
        HashSet<String> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        ArrayList<String> dishes = new ArrayList<>();
        dishes.add("Pizza");
        dishes.add("Burger");
        dishes.add("Pasta");
        dishes.add("Pizza");
        dishes.add("Burger");

        System.out.println("Original list: " + dishes);
        ArrayList<String> uniqueDishes = removeDuplicates(dishes);
        System.out.println("After removing duplicates: " + uniqueDishes);
    }
}
