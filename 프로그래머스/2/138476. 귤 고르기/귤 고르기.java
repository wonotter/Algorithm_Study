import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int one : tangerine) {
            map.put(one, map.getOrDefault(one, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        
        int answer = 0;
        for (int key : list) {
            int size = map.get(key);
            k -= size;
            answer++;
            
            if (k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}
