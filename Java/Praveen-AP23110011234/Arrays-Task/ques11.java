import java.util.Scanner;
public class ques11 {
    //11.	Write a program to search a given element in an array (linear search).
    //11.	Write a program to search a given element in an array (linear search).
    public static void main(String[] args) {
        int[] arr = {10, 15, 22, 33, 40, 55, 60};
        //int target = 33; // Element to search for
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the element to search: ");
        int target = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element " + target + " found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Element " + target + " not found in the array.");
        }
        sc.close();
    }
}
