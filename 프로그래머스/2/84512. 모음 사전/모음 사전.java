import java.util.*;

class Solution {
    static String[] alphabets = new String[]{"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        DFS("");
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i + 1;
            }
        }
        
        return 0;
    }
    
    static void DFS(String current) {
        if (!current.equals("")) {
            list.add(current);
        }
        
        if (current.length() == 5) {
            return;
        }
        
        for (int i = 0; i < alphabets.length; i++) {
            DFS(current + alphabets[i]);
        }
    }
}
