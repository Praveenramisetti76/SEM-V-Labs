import java.util.Scanner;
class calculator{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter first number");
        int a=sc.nextInt();
        System.out.println("enter second number");
        int b=sc.nextInt();
        System.out.println("enter an operator (+, -, *, /, %)");
        char op=sc.next().charAt(0);
        int result=0;
        switch(op){
            case '+': result=a+b; break;
            case '-': result=a-b; break;
            case '*': result=a*b; break;
            case '/': result=a/b; break;
            case '%': result=a%b; break;
            default: System.out.println("Invalid operator");
        }
        System.out.println("the result is "+result);
        sc.close();
    }
}