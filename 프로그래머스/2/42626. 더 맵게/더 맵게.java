import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int food : scoville) {
            pq.add(food);
        }
        
        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            int newFood = first + (second * 2);
            pq.add(newFood);
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        } else {
            return answer;
        }
    }
}
