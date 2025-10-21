import java.util.Arrays;
import java.util.Collections;
public class ques13 {
    //13.	Write a program to sort an array in descending order using Arrays.sort() with Collections.reverseOrder().
    public static void main(String[] args) {
        Integer[] arr = {34, 12, 5, 67, 23, 89, 1};
       // Arrays.sort(arr, Collections.reverseOrder());
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println("Sorted array in descending order:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}   
