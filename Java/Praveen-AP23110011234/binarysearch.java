import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class binarysearch {
    public static void binarySearchExample() {
        int[] arr = {10, 20, 30,40, 50};
        int target = 30;
        int result = Arrays.binarySearch(arr, target);
        if (result >= 0) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
    public static void copyarray()
    {
        int [] original ={1,2,3,4,5};
        int [] copy =original.clone();
        System.out.println("Original array: " + Arrays.toString(original));
        System.out.println("Copied array: " + Arrays.toString(copy));
    }
    public static void copyarraymethod()
    {
        int [] original={1,2,3,45};
        int[] copy=Arrays.copyOf(original, 3);
        System.out.println("Original array: " + Arrays.toString(original));
        for(int num: copy){
            System.out.println(num);
        }
    }
    public static void sorting()
    {
        int[] nums={1,2,3,4,5};
        System.out.println("Before sorting: " +Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("After sorting: " +Arrays.toString(nums));
    }
    public static void descendingorder()
    {
        Integer[] nums={1,2,3,4,};
        Arrays.sort(nums,Collections.reverseOrder());
        System.out.println("descending order:" +Arrays.toString(nums));
    }
       public static void sort2darray() {
        int arr[][] = {
            {1, 2, 3},
            {4, 5, 6},
        };

        // sorting each row
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }

        // printing sorted 2D array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                
                System.out.print(arr[i][j] + " "); // ✅ changed to print
            }
            System.out.println(); // ✅ new line after finishing each row
        }
    }
    public static void main(String[] args)
    {
        // binarySearchExample();
        // copyarray();
        // copyarraymethod();
        // sorting();
        // descendingorder();
        sort2darray();
    }
}
