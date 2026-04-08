import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        // 최초 다리는 빈 칸을 의미하는 0으로 채움
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int idx = 0;
        
        // 모든 트럭을 다리 위에 올릴 때 까지 반복
        while (idx < truck_weights.length) {
            time++;
            
            // 매 초마다 맨 앞칸이 빠져나감
            currentWeight -= bridge.poll();
            
            // 다음 트럭이 올라올 수 있다면
            if (currentWeight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                currentWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        
        // 마지막 트럭이 큐에서 빠져나가기까지 시간 추가
        time += bridge_length;
        
        return time;
    }
}
