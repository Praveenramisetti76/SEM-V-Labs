import java.util.*;
public class ques19 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        //split the string
        String[] arr=str.split(" ");
        System.out.println("The split strings are: ");
        for(String s: arr)
        {
            System.out.println(s);
        }
}
}
