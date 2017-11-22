import java.util.*;

public class Knapsack {
    static int optimalWeightGreedy(int W, int[] w) {

        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }

    static int max(int a, int b){
        return (a > b)? a : b;
    }

    static int optimalWeight(int W, int[] wt) {
        //write you code here

        int[] val = wt;
        int n = wt.length;
        int[][] value = new int[n+1][W+1];
        int i, w;
        for (i= 0; i<=n; i++){
            for (w = 0; w<=W; w++){
                if(i==0 || w==0){
                    value[i][w]=0;
                } else if(wt[i-1] <= w){
                    value[i][w] = max(val[i-1] + value[i-1][w-wt[i-1]], value[i-1][w]);
                } else {
                    value[i][w] = value[i-1][w];
                }
            }
        }


        return value[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
