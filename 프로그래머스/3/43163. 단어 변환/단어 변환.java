import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean found = false;
        
        for (String word : words) {    
            if (target.equals(word)) {
                found = true;
                break;
            }
        }
        
        if (!found) {
            return 0;
        }
        
        return BFS(begin, target, words);
    }
    
    public static int BFS(String begin, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            
            if (now.word.equals(target)) {
                return now.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canChange(now.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Word(words[i], now.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    public static boolean canChange(String first, String second) {
        int diff = 0;
        
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        
        return diff == 1;
    }
}

class Word {
    String word;
    int count;
    
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
