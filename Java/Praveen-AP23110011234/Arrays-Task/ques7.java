public class ques7 {
    //7.	Write a program to copy elements of one array into another using a loop (not Arrays.copyOf).
    public static void main(String[] args) {
        int[] sourceArray = {1, 2, 3, 4, 5};
        int[] destinationArray = new int[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            destinationArray[i] = sourceArray[i];
        }
        System.out.println("Elements of the destination array:");
        for (int i = 0; i < destinationArray.length; i++) {
            System.out.println(destinationArray[i]);
        }
    }
}
