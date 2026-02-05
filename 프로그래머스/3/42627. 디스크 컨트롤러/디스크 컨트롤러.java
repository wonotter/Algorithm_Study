import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Jobs> pq = new PriorityQueue<>();
        
        int idx = 0;
        int time = jobs[0][0];
        
        while (idx < jobs.length || !pq.isEmpty()) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Jobs(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                pq.add(new Jobs(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            Jobs job = pq.poll();
            time += job.duration;
            answer += time - job.requestTime;
        }
        
        return answer / jobs.length;
    }
}

class Jobs implements Comparable<Jobs> {
    
    int jobNumber;
    int requestTime;
    int duration;
    
    public Jobs(int jobNumber, int requestTime, int duration) {
        this.jobNumber = jobNumber;
        this.requestTime = requestTime;
        this.duration = duration;
    }
    
    @Override
    public int compareTo(Jobs o) {
        int c = Integer.compare(this.duration, o.duration);
        if (c != 0)
            return c;
        
        c = Integer.compare(this.requestTime, o.requestTime);
        if (c != 0)
            return c;
        
        return Integer.compare(this.jobNumber, o.jobNumber);
    }
}