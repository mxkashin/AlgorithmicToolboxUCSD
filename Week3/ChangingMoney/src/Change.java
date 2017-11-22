import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
        //write your code here
        int m = 0;
        if (n >= 10){
            m += n / 10;
            n = n % 10;
        }
        if (n >= 5){
            m += n / 5;
            n = n % 5;
        }
        m += n;

        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}
