import java.util.Scanner;

public class LCM {
    private static long lcm_naive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l)
            if (l % a == 0 && l % b == 0)
                return l;

        return (long) a * b;
    }

    private static long lcm(int a, int b) {
        int gcd = gcdFast(a,b);
        long lcm = ((long)(a / gcd)) * b;
        return lcm;
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
        System.out.println(lcm(a, b));
    }
}
