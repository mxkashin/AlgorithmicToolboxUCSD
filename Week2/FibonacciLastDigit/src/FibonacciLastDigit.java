import java.util.Scanner;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;
        int previous = 0;
        int current  = 1;
        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }
        return current % 10;
    }

    private static int getFibonacciLastDigit(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n ; i++){
            array[i] = (array[i-1] + array[i-2]) % 10;
        }
        return array[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 0 || n > 10000000){
            throw new IllegalArgumentException("out of bounds ");
        }
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}
