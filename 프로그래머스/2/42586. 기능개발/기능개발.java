import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> days = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int workLoad = 100 - progresses[i];
            
            int workDays = 0;
            while (workLoad > 0) {
                workLoad -= speeds[i];
                workDays++;
            }
            
            days.add(workDays);
        }
        
        int count = 1;
        int current = days.get(0);
        
        for (int i = 1; i < days.size(); i++) {
            if (days.get(i) <= current) {
                count++;
            } else {
                answer.add(count);
                current = days.get(i);
                count = 1;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
