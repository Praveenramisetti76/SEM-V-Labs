import java.util.*;
public class ques2 {
     public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println("Concatenated string is: "+str.concat(str2));
        System.out.println("Length of concatenated string is: "+str.concat(str2).length());
        }
}
