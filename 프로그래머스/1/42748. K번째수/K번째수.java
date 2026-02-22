import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            
            Arrays.sort(temp);
            answer.add(temp[command[2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
