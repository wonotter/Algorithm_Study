import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> answer;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            
            return a[0].compareTo(b[0]);
        });
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        DFS("ICN", path, 0, tickets);
        
        return answer.toArray(new String[0]);
    }
    
    public static boolean DFS(String cur, List<String> path, int count, String[][] tickets) {
        
        if (count == tickets.length) {
            answer = new ArrayList<>(path);
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                if (DFS(tickets[i][1], path, count + 1, tickets)) {
                    return true;
                }
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}
