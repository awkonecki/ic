public class Solution {

    // [F]unctional
    public static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }   

        int [] dp = new int [] {0, 1};
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        int value = n - 1;

        while (value > 0) {
            dp[1] += dp[0];
            dp[0] = dp[1] - dp[0];
            value--;
        }

        return fib(n, new int [n + 1]);
    }

    private static int fibRec(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        return fibRec(n - 1) + fibRec(n - 2);
    }

    // Memoization
    private static int fib(int n, int [] dp) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int value = fib(n - 1, dp) + fib(n - 2, dp);

        dp[n] = value;
        return value;
    }
    

    public static void main(String [] args) {
        assert (fib(0) == 0);
        assert (fib(1) == 1);
        assert (fib(2) == 1);
        assert (fib(3) == 2);
    }
}