import java.util.Arrays;
public class ques12 {
    //12.	Write a program to sort an array in ascending order using Arrays.sort() and print the sorted array.
    public static void main(String[] args) {
        int[] arr = {34, 12, 5, 67, 23, 89, 1};
        Arrays.sort(arr);
        System.out.println("Sorted array in ascending order:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
