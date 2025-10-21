public class ques2 {
    public static void main(String[] args)
    {
        //2.	Find the length of an array of strings and print each string with its index.
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        System.out.println("Length of the array: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index " + i + ": " + arr[i]);
        }
    }
}
