import java.util.Scanner;

public class Fibonacci {
    //naive algorithm
    private static long calcFib(int n) {
        if (n <= 1)
            return n;

        return calcFib(n - 1) + calcFib(n - 2);
    }

    //efficient algorithm
    private static long calcFibFast(int n){
        int[] f = new int[n+1];
        f[0] = 0;

        if (n > 0){
            f[1] = 1;

            for (int i = 2; i <= n; i++ ){
                f[i] = f[i-1]+ f[i-2];
            }
        }
        return f[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n > 45 || n < 0){
            throw new IllegalArgumentException("0 <= n <= 45");
        }

        System.out.println(calcFibFast(n));
    }
}
