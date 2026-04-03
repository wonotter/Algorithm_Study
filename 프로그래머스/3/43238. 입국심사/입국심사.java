import java.util.*;
import java.util.stream.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 1;
        long right = 0;
        
        int max = Arrays.stream(times).max().orElse(0);
        
        right = (long) max * n;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            // mid 시간 동안 총 몇 명 심사 가능한지 계산
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }
            
            // n명 이상 처리가 가능한 경우
            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
