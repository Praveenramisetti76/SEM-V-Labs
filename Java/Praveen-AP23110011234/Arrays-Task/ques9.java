public class ques9 {
    //9.	Write a program to find the even numbers in an array and print them.
    public static void main(String[] args) {
        int[] arr = {10, 15, 22, 33, 40, 55, 60};
        System.out.println("Even numbers in the array:");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
