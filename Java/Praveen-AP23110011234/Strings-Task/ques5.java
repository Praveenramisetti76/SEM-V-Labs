import java.util.*;

public class ques5 {
     public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        int place=sc.nextInt();
        char ch=str.charAt(place);
        System.out.println("Character at position "+place+" is: "+ch);
        }
}
