import java.util.Scanner;
public class test {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a integer");
        int num=sc.nextInt();
        String s=sc.next();
        System.out.println("your string is "+s);
        System.out.println(num);
        sc.close();
    }
}
