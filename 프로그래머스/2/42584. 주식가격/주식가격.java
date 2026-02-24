import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            stack.push(i);
        }
        
        // 값이 떨어지지 않은 가격 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (prices.length - 1) - idx;
        }
        
        return answer;
    }
}
