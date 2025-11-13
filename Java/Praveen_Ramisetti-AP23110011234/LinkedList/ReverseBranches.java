import java.util.*;

public class ReverseBranches {
    public static void main(String[] args) {
        LinkedList<String> branches = new LinkedList<>();
        branches.add("Hyderabad");
        branches.add("Chennai");
        branches.add("Delhi");
        branches.add("Mumbai");

        System.out.println("Original Branches: " + branches);

        Collections.reverse(branches);

        System.out.println("Reversed Branches: " + branches);
    }
}
