import java.util.Scanner;

public class GCD {
    private static int gcdNaive(int a, int b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }
        return current_gcd;
    }

    private static int gcdFast(int a, int b){
        int current_gcd;
        if (b == 0){
            return a;
        } else {
            int remainder = a % b;
            current_gcd = gcdFast(b, remainder);
        }

        return current_gcd;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a < 1 || b < 1 || a > 2000_000_000 || b > 2000_000_000){
            throw new IllegalArgumentException("out of bounds");
        }

        System.out.println(gcdFast(a, b));
    }
}
