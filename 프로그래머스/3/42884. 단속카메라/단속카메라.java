import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int pos = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        pos = routes[0][1];
        answer++;
        
        for (int i = 1; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            // 카메라 범위를 벗어난 경우
            if (pos < start || pos > end) {
                pos = end;
                answer++;
            }
        }
        
        return answer;
    }
}
