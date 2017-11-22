import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static int minOp(int n){
        int[] sol = new int[n+1];
        sol[0] = 0;

        int num;
        for (int i = 1; i<=n; i++){
            sol[i] = n;
            for (int j =1; j<= 3;j++){
                if(j ==1){
                    num = sol[i - 1] +1;
                    if (num < sol[i]){
                        sol[i] = num;
                    }
                }
                if (j == 2 && i % 2 ==0){
                    num = sol[i / 2] +1;
                    if (num < sol[i]){
                        sol[i] = num;
                    }
                }
                if (j ==3 && i % 3 ==0){
                    num = sol[i / 3] +1;
                    if (num < sol[i]){
                        sol[i] = num;
                    }
                }
            }

        }
        return sol[n];
    }

    private static List<Integer> optimal_sequenceDP(int n){
        List<Integer> sequence = new ArrayList<Integer>();
        int length = minOp(n);
        sequence.add(n);
        while(n != 1){
            if (n % 3 == 0 && minOp(n/3) == length -1){
                sequence.add(n/3);
                n = n/3;
                length = length -1;
            } else if (n % 2 ==0 && minOp(n/2) == length -1){
                sequence.add(n/2);
                n = n/2;
                length = length -1;
            } else {
                sequence.add(n-1);
                n = n-1;
                length = length -1;
            }
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequenceDP(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
