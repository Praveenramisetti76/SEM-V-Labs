import java.util.Scanner;

public class CRC {
    
    // Function to perform XOR division
    public static String xorDivision(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);

        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(divisor, tmp) + dividend.charAt(pick);
            } else {
                tmp = xor("0".repeat(pick), tmp) + dividend.charAt(pick);
            }
            pick++;
        }

        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp);
        } else {
            tmp = xor("0".repeat(pick), tmp);
        }

        return tmp;
    }

    // Function to perform XOR between two binary strings
    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input message
        System.out.print("Enter the dataword (binary): ");
        String dataword = sc.nextLine();

        // Input generator
        System.out.print("Enter the generator polynomial (binary): ");
        String generator = sc.nextLine();

        int m = generator.length() - 1;

        // Append m zeros to dataword
        String dividend = dataword + "0".repeat(m);

        // Get remainder
        String remainder = xorDivision(dividend, generator);

        // Codeword = dataword + remainder
        String codeword = dataword + remainder;

        System.out.println("Remainder (CRC bits): " + remainder);
        System.out.println("Transmitted Codeword: " + codeword);

        // Receiver side check
        System.out.print("\nEnter received codeword (binary): ");
        String received = sc.nextLine();

        String check = xorDivision(received, generator);

        if (check.contains("1")) {
            System.out.println("Error detected in received codeword!");
        } else {
            System.out.println("No error detected. Codeword is valid.");
        }

        sc.close();
    }
}