public class ques10 {
    //10.	Write a program to find the odd numbers in an array and count how many odd numbers are present.
    public static void main(String[] args) {
        int[] arr = {10, 15, 22, 33, 40, 55, 60};
        int count = 0;
        System.out.println("Odd numbers in the array:");
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                System.out.println(arr[i]);
                count++;
            }
        }
        System.out.println("Total odd numbers: " + count);
    }
}
