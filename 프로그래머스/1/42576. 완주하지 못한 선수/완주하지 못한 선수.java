import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (String runner : participant) {
            hashMap.put(runner, hashMap.getOrDefault(runner, 0) + 1);
        }
        
        for (String runner : completion) {
            hashMap.put(runner, hashMap.get(runner) - 1);
        }
        
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) != 0) {
                return key;
            } 
        }
        return answer;
    }
}
