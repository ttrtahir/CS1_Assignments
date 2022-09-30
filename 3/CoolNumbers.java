import java.util.*;

public class CoolNumbers {
    public static void main(String[] args) {
        // This is just to test your method
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(countCools(n, a, b));

        scanner.close();
    }

    public static boolean isCool(int coolCandidate, int coolChecker) {
        // your code here
        int righthandDigit = coolCandidate % 10;

        do {
            if (righthandDigit == 0)
                return false;
            else if (coolChecker % righthandDigit != 0)
                return false;

            coolCandidate /= 10;
            righthandDigit = coolCandidate % 10;
        } while (coolCandidate > 0);

        return true;
    }

    public static int countCools(int n, int a, int b) {
        // your code here
        int count = 0;

        for (int temp = a; temp <= b; temp++) {
            if (isCool(temp, n))
                count++;
        }

        return count;
    }

}