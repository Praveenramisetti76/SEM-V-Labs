import java.util.Scanner;

public class Arithmetic {
 
    public static void main(String[] args)
    {


        //narrowing with truncation and narrowing with overflow 

    //        int a=10;
    //         float b=3.2f;
    //     System.out.println(a);
    //     System.out.println(b);
    //   //  System.out.println(a*b+a/b);

    //     // assign a byte value to a long 
    //     byte c=100;
    //     long l= (byte)b;
    //     System.out.println("Byte Value" +c);
    //     System.out.println("Long value" +l);

    //     // convert a double value to a int
    //       double res=3.14;
    //     int res2=(int) res;
    //     System.out.println(res2);

    //     // assign an int value to a byte with explicit casting
    //    int d=11;
    //    byte f = (byte)d;
    //    System.out.println(d);
    
       // write a java program to print the factorial number input should be taken from user
        // write a java program to print the reverse number 
        // to check wheather given num is palindrome or not
        // Create Scanner object
        Scanner sc = new Scanner(System.in);
        // Taking integer input
        System.out.println("Enter an integer: ");
        int num = sc.nextInt();
    int fact=1;
    for(int i=1;i<=num;i++)
    {
        fact*=i;
    }
    System.out.println("factorial of num is "+fact);
    System.out.println("enter the integer 2");
    int num2=sc.nextInt();
    int temp=num2;
    int res=0;
    while(temp!=0)
    {
       int digit=temp%10;
        res=res*10 +digit;
        temp/=10;
    }
    System.out.println(res);
    // System.out.println("enter the number 3");
    // int num3=sc.nextInt();
    if(res==num2){
        System.out.println("it is a palindrome");
    }
else{ System.out.println(" not a palindrome");
}
 sc.close();
    }
}
