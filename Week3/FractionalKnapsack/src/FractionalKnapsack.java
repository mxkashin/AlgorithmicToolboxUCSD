import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        int n = values.length;
        double[] A = new double[n];
        for (int i = 0; i< n; i++){
            A[i] = ((double)values[i]) / weights[i];
        }
        Arrays.sort(A);
        int[] vSort = new int[n];
        int[] wSort = new int[n];
        for (int i = 0; i< n; i++){
            for (int j = 0; j< n; j++){
                if (A[n - 1 - i] == ((double)values[j]) / weights[j]){
                    vSort[i] = values[j];
                    wSort[i] = weights[j];
                }
            }
        }

        for (int i = 0; i< n; i++){
            if (capacity == 0){
                return value;
            }
            int a = Math.min(wSort[i], capacity);
            value = value + a * ((double)vSort[i]) / wSort[i];
            capacity = capacity - a;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(String.format("%.4f", getOptimalValue(capacity, values, weights)));
    }
}
