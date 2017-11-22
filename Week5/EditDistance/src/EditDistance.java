import java.util.*;

public class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here
        int n = s.length();
        int m = t.length();
        int[][] D = new int[n+1][m+1];
        int i, j;
        for (i = 0; i <= n; i++){
            D[i][0] = i;
        }
        for (j = 0; j <= m; j++){
            D[0][j] = j;
        }

        for (j = 1; j <= m; j++){
            for (i = 1; i <= n; i++){
                int ins = D[i][j-1]+1;
                int del = D[i-1][j]+1;
                int match = D[i-1][j-1];
                int mismatch = D[i-1][j-1]+1;
                if (s.charAt(i-1) == t.charAt(j-1)){
                    D[i][j] = Math.min(ins, Math.min(del, match));

                } else {
                    D[i][j] = Math.min(ins, Math.min(del, mismatch));
                }
            }
        }


        return D[n][m];
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
