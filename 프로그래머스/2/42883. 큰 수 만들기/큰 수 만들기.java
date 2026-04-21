import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        
        char[] numberChar = number.toCharArray();
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int next = numberChar[i] - '0';
            
            while (!stack.isEmpty() && stack.peek() < next && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(next);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            String one = String.valueOf(stack.pop());
            answer.insert(0, one);
        }
        
        return answer.toString();
    }
}
