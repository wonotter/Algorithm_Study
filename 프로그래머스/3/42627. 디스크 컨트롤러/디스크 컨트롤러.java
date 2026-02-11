import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int idx = 0;
        int time = jobs[0][0];
        
        while (idx < jobs.length || !pq.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                pq.add(jobs[idx++]);
            }
            
            int[] job = pq.poll();
            time += job[1];
            answer += time - job[0];
        }
        
        return answer / jobs.length;
    }
}
