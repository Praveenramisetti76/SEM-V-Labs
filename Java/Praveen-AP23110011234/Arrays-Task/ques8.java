import java.util.Arrays;
public class ques8 {
   // 8.	Write a program to copy an array using Arrays.copyOfRange() and print the copied values.
   public static void main(String[] args){
    int[] originalArray = {10, 20, 30, 40, 50};
    int[] copiedArray = Arrays.copyOfRange(originalArray, 1, 4);
    System.out.println("Copied array elements:");
    for (int i = 0; i < copiedArray.length; i++) {
        System.out.println(copiedArray[i]);
    }
   }
}
