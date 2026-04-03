import java.util.*;

class Solution {
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            boolean[] visited = new boolean[n + 1];
            
            int count = DFS(1, visited);
            
            int diff = Math.abs(count - (n - count));
            
            answer = Math.min(answer, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    public static int DFS(int start, boolean[] visited) {
        visited[start] = true;
        
        int count = 1;
        for (int next : graph[start]) {
            if (!visited[next]) {
                count += DFS(next, visited);
            }
        }
        
        return count;
    }
}
