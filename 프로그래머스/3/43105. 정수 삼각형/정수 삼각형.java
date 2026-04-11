import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        int[][] dp = new int[n][n];
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + triangle[i][0];
                } else if (j == triangle[i].length - 1) {
                    dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
                } else { // dp의 기준은 현재 칸까지 내려왔을 때 만들 수 있는 최대 합
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        return Arrays.stream(dp[n - 1]).max().orElse(0);
    }
}
