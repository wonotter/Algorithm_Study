import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        // 우선순위 큐 2개를 생성해서 하나는 오름차순, 하나는 내림차순 정렬
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String op = operation.substring(0, 1);
            String stringData = operation.substring(2);
            int data = Integer.parseInt(stringData);
            
            if (op.equals("I")) {
                pqMin.add(data);
                pqMax.add(data);
            } else if (op.equals("D")) {
                if (data == 1 && !pqMax.isEmpty()) {
                    int max = pqMax.poll();
                    pqMin.remove(max);
                } else if (data == -1 && !pqMin.isEmpty()) {
                    int min = pqMin.poll();
                    pqMax.remove(min);
                }
            }
        }
        
        if (pqMin.isEmpty() && pqMax.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            
            return answer;
        } else {
            answer[0] = pqMax.poll();
            answer[1] = pqMin.poll();
            
            return answer;
        }
    }
}
