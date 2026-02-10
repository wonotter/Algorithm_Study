import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.addLast(num);
            }
        }
        
        for (int num : deque) {
            answer.add(num);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
