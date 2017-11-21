import java.io.*;
import java.util.*;

public class MaxPairwiseProduct {
    //starter solution
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * numbers[j] > result) {
                    result = (long)numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
    //Faster solution
    static long getMaxPairwiseProductFast(int[] numbers){
        long result;
        int n = numbers.length;
        int maxIdx1 = -1;
        int maxIdx2 = -1;
        for (int i = 0; i < n; i++){
            if (maxIdx1 == -1 || numbers[maxIdx1] < numbers[i])
                maxIdx1 = i;
        }
        for (int i = 0; i < n; i++){
            if ((i != maxIdx1) && (maxIdx2 == -1 || numbers[maxIdx2] < numbers[i]))
                maxIdx2 = i;
        }
        result = (long) numbers[maxIdx1] * numbers[maxIdx2];
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));

        /** //Stress testing
        while (true) {
    	      Random rand = new Random();
    	      int k = rand.nextInt(10) + 2;
    	      System.out.println(k);
    	      ArrayList<Integer> num = new ArrayList<Integer>();
    	      for (int i = 0; i< k ; i++){
    	      	    num.add(rand.nextInt(1000));
    	      }
    	      int[] a = num.stream().mapToInt(i -> i).toArray();
    	      for (int i = 0; i< k; i++){
    	      	    System.out.println (a[i]+"\t");
    	      }

    	      long res1 = getMaxPairwiseProduct(a);
    	      long res2 = getMaxPairwiseProductFast(a);
    	      if (res1 != res2){
    	      	    System.out.println("Wrong"+ res1+ " "+res2);
    	      	    break;
    	      } else {
    	        	System.out.println("OK");
            }
        }
         */
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
