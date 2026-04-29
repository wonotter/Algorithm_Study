import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        long sum = Arrays.stream(works).sum();
        if (sum <= n) {
            return 0;
        }
        
        for (int work : works) {
            pq.add((long) work);
        }
        
        while (n > 0) {
            long workload = pq.poll();
            workload--;
            pq.add(workload);
            n--;
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            long one = pq.poll();
            answer += one * one;
        }
        
        return answer;
    }
}
