import java.util.Scanner;

public class StudentReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input student details
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();

        System.out.print("Enter marks for subject 1: ");
        int marks1 = sc.nextInt();

        System.out.print("Enter marks for subject 2: ");
        int marks2 = sc.nextInt();

        System.out.print("Enter marks for subject 3: ");
        int marks3 = sc.nextInt();

        // Calculate average
        double average = (marks1 + marks2 + marks3) / 3.0;

        // Determine grade
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 75) {
            grade = "A";
        } else if (average >= 50) {
            grade = "B";
        } else {
            grade = "Fail";
        }

        // Display report card
        System.out.println("\n----- Student Report Card -----");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks1 + ", " + marks2 + ", " + marks3);
        System.out.println("Average    : " + average);
        System.out.println("Grade      : " + grade);
        sc.close();
    }
}
