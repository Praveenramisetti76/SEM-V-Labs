public class ques3 {
    //3.	Write a program to find the sum and average of elements in an integer array.
    public static void main(String[] args){
    float avg;
    int[] arr ={10,20,30,40,50};
    int sum = 0;
    for(int i=0;i<arr.length;i++){
        sum = sum + arr[i];
    }
    avg = (float)sum/arr.length;
    System.out.println("Sum: "+sum);
    System.out.println("Average: "+avg);

}
}
