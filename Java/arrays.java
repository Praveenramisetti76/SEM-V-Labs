import java.util.Arrays;

public class arrays {
    public static void main(String[] args){
        int[] numbers={10,20,30,40,50};
        System.out.println(numbers.length);
        System.out.println(numbers);
        String[] names={"praveen","ramisetti","sindhu"};
        System.out.println(Arrays.toString(numbers)); // prints the entire array in string format
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
        for(String name:names){
            System.out.println(name);
        }
        System.out.println(Arrays.toString(names));
    }
}
