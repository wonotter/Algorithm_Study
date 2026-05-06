import java.util.*;

class Solution {
    static HashMap<String, Integer> benefit = new HashMap<>();
    static HashMap<String, String> recommend = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            recommend.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            DFS(seller[i], amount[i] * 100);
        }
        
        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = benefit.getOrDefault(enroll[i], 0);
        }
        
        return result;
    }
    
    public static void DFS(String oneSeller, int sales) {
        int nextSales = sales / 10;
        
        benefit.put(oneSeller, benefit.getOrDefault(oneSeller, 0) + sales - nextSales);
        
        if (nextSales > 0 && recommend.containsKey(oneSeller)) {
            DFS(recommend.get(oneSeller), nextSales);
        }
    }
}
