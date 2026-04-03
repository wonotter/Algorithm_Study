import java.util.*;
import java.util.stream.*;

class Solution {
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] oneEdge : edge) {
            graph[oneEdge[0]].add(oneEdge[1]);
            graph[oneEdge[1]].add(oneEdge[0]);
        }
        
        int[] answers = BFS(1, n);
        
        int max = Arrays.stream(answers).max().orElse(0);
        
        int answer = 0;
        for (int one : answers) {
            if (max == one) {
                answer++;
            }
        }
        return answer;
    }
    
    public static int[] BFS(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        
        queue.add(start);
        visited[1] = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph[now]) {
                if (visited[next] == -1) {
                    queue.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        
        return visited;
    }
}
