import java.util.*;

public class RestaurantMenu {
    public static void main(String[] args) {
        ArrayList<String> menu = new ArrayList<>();

        menu.add("chai");
        menu.add("Burger");
        menu.add("Pasta");
        menu.add("Sandwich");
        menu.add("Cold Coffee");

        System.out.println("Restaurant Menu:");
        for (String item : menu) {
            System.out.println(item);
        }
    }
}
