public class ques4 {
    public static void main(String[] args) {
       //4.	Write a program to find the maximum and minimum value in a floating-point array.
        float[] arr = {12.5f, 3.7f, 9.8f, 15.2f, 7.4f};
        float max = arr[0];
        float min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}
