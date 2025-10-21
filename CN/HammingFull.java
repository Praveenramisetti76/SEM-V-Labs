import java.util.Scanner;
// this code takes the input without redundancy then gives the with reduncy and finds which positon we enterd wrong 
public class HammingFull {
    // Check if a number is power of two
    static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }

    // Compute number of parity bits required for m data bits
    static int parityCount(int m) {
        int r = 0;
        while ((1 << r) < (m + r + 1)) r++;
        return r;
    }

    // Encode given data bits (msg[]: index 0..m-1, left->right MSB->LSB)
    // returns code array indexed by position 1..total (we ignore index 0)
    static int[] encode(int[] msg) {
        int m = msg.length;
        int r = parityCount(m);
        int total = m + r;
        int[] code = new int[total + 1]; // 1-indexed

        // Place data bits into non-parity positions from highest pos -> 1
        int di = 0; // index into msg (0..m-1)
        for (int pos = total; pos >= 1; pos--) {
            if (isPowerOfTwo(pos)) {
                code[pos] = 0; // placeholder for parity
            } else {
                code[pos] = msg[di++]; // fill using msg left->right
            }
        }

        // Calculate parity bits (even parity). For parity position p = 2^i:
        // parity = XOR of all bits in positions where (pos & p) != 0
        for (int i = 0; (1 << i) <= total; i++) {
            int p = 1 << i;
            int xor = 0;
            for (int pos = 1; pos <= total; pos++) {
                if ((pos & p) != 0) {
                    xor ^= code[pos];
                }
            }
            code[p] = xor;
        }

        return code;
    }

    // Detect error in received code (received is 1-indexed array: index 1..n)
    // returns error position (1..n) where bit is wrong; 0 means no error
    static int detectError(int[] received) {
        int n = received.length - 1;
        int errorPos = 0;
        for (int i = 0; (1 << i) <= n; i++) {
            int p = 1 << i;
            int xor = 0;
            for (int pos = 1; pos <= n; pos++) {
                if ((pos & p) != 0) {
                    xor ^= received[pos];
                }
            }
            if (xor == 1) errorPos += p;
        }
        return errorPos;
    }

    // Utility to print code from highest pos down to 1
    static void printCodeHighToLow(int[] code) {
        StringBuilder sb = new StringBuilder();
        for (int pos = code.length - 1; pos >= 1; pos--) {
            sb.append(code[pos]);
            if (pos != 1) sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Phase 1: get data bits and encode
        System.out.print("Enter number of data bits (m): ");
        int m = sc.nextInt();
        int[] msg = new int[m];
        System.out.print("Enter data bits (space separated, left->right MSB->LSB): ");
        for (int i = 0; i < m; i++) msg[i] = sc.nextInt();

        int[] encoded = encode(msg);
        int total = encoded.length - 1;
        System.out.println("\nCalculated Hamming code (positions " + total + " → 1):");
        printCodeHighToLow(encoded);
        System.out.println("(Rightmost printed bit is position 1)");

        // Phase 2: accept received code and detect error
        System.out.print("\nEnter length of received Hamming code (n): ");
        int n = sc.nextInt();
        int[] received = new int[n + 1]; // 1-indexed
        System.out.print("Enter received bits (space separated, left->right MSB->LSB): ");
        for (int i = n; i >= 1; i--) {
            // we read left->right, which corresponds to pos n -> pos 1
            // but user gives same ordering as printed above (pos total .. 1),
            // so reading left->right into positions n..1 keeps positions consistent.
            received[i] = sc.nextInt();
        }

        // If n differs from encoded length, we still detect on received array.
        int errorPos = detectError(received);

        if (errorPos == 0) {
            System.out.println("✅ No single-bit error detected in received code.");
        } else {
            System.out.println("❌ Error detected at bit position (counting from right, pos 1): " + errorPos);
            // Show before/after correction and the corrected code
            System.out.print("Received code (before correction, positions " + n + " → 1): ");
            printCodeHighToLow(received);

            // correct
            received[errorPos] ^= 1;

            System.out.print("Corrected code (positions " + n + " → 1): ");
            printCodeHighToLow(received);
        }

        sc.close();
    }
}
