import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        HashSet<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        // 1부터 8까지 반복
        for (int i = 1; i <= 8; i++) {
            // N을 i번 이어붙인 수 먼저 넣기
            int repeated = 0;
            for (int k = 0; k < i; k++) {
                repeated = repeated * 10 + N;
            }
            dp[i].add(repeated);
            
            // j개 사용한 결과 + (i - j)개 사용한 결과 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
