import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        for (Integer key : hashMap.keySet()) {
            answer++;
        }
        
        if ((nums.length / 2) < answer) {
            answer = nums.length / 2;
        }
        
        return answer;
    }
}