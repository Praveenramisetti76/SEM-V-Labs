public class ques6 {
    //6.	Reverse the elements of an array and print the reversed array.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println("Reversed array:");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
