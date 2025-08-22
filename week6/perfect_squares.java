package week6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class perfect_squares {
    public static void main(String[] args) {
        System.out.println(numSquares(13)); 
        System.out.println(numSquares(27)); 
        System.out.println(numSquares(1)); 
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        
        for (int i = 1; i <= n; i++) {
            for (int square : squares) {
                if (i - square >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }

        return dp[n];
    }
}
