import java.util.Scanner;

public class simpletask{
    
    public static void variablesExample() {
        int num = 10;
        double price = 99.99;
        char letter = 'A';
        boolean isJavaFun = true;

        System.out.println("Integer: " + num);
        System.out.println("Double: " + price);
        System.out.println("Character: " + letter);
        System.out.println("Boolean: " + isJavaFun);
    }

    public static void areaOfCircle() {
        double radius = 7.0;
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }

    public static void charAscii() {
        char ch = 'X';
        int ascii = (int) ch;
        System.out.println("Character: " + ch);
        System.out.println("ASCII Value: " + ascii);
    }

    public static void wideningConversion() {
        int num = 100;
        double d = num;
        System.out.println("Integer value: " + num);
        System.out.println("Converted to double: " + d);
    }

    public static void narrowingConversion() {
        double d = 9.78;
        int num = (int) d;
        System.out.println("Double value: " + d);
        System.out.println("Converted to int: " + num);
    }

    public static void arithmeticOps() {
        int a = 15, b = 4;
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));
    }

    public static void relationalLogical() {
        int num = 15;
        boolean result = (num > 10 && num < 20);
        System.out.println("Is " + num + " between 10 and 20? " + result);
    }

    public static void ifElseCheck() {
        int num = -5;
        if (num > 0) {
            System.out.println(num + " is Positive");
        } else if (num < 0) {
            System.out.println(num + " is Negative");
        } else {
            System.out.println("Number is Zero");
        }
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.print("Enter operator (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result: " + (a + b)); break;
            case '-': System.out.println("Result: " + (a - b)); break;
            case '*': System.out.println("Result: " + (a * b)); break;
            case '/': 
                if (b != 0) System.out.println("Result: " + (a / b));
                else System.out.println("Division by zero not allowed!");
                break;
            default: System.out.println("Invalid Operator");
        }
        sc.close();
    }

    public static void multiplicationTable() {
        int num = 5;
        System.out.println("Multiplication Table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Declare and Print Variables");
            System.out.println("2. Area of a Circle");
            System.out.println("3. Character and ASCII Value");
            System.out.println("4. Widening Conversion");
            System.out.println("5. Narrowing Conversion");
            System.out.println("6. Arithmetic Operators");
            System.out.println("7. Relational & Logical Operators");
            System.out.println("8. If-Else Condition");
            System.out.println("9. Calculator (Switch Case)");
            System.out.println("10. Multiplication Table");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1: variablesExample(); break;
                case 2: areaOfCircle(); break;
                case 3: charAscii(); break;
                case 4: wideningConversion(); break;
                case 5: narrowingConversion(); break;
                case 6: arithmeticOps(); break;
                case 7: relationalLogical(); break;
                case 8: ifElseCheck(); break;
                case 9: calculator(); break;
                case 10: multiplicationTable(); break;
                case 0: System.out.println("Exiting program..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}