import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    graph[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void DFS(int start) {
        visited[start] = true;
        
        for (int next : graph[start]) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
}
