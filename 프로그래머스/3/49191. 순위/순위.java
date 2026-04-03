import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        // 단방향 그래프 구성 (a가 b를 이기는 그래프)
        List<Integer>[] winGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            winGraph[result[0]].add(result[1]);
        }
        
        // 역 단방향 그래프 구성 (a가 b에게 지는 그래프)
        List<Integer>[] loseGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            loseGraph[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            loseGraph[result[1]].add(result[0]);
        }
        
        int answer = 0;
        // 각 선수마다 이길 수 있는 사람과 지는 사람 카운트
        for (int i = 1; i <= n; i++) {
            int winCount = BFS(i, winGraph, n);
            int loseCount = BFS(i, loseGraph, n);
            
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static int BFS(int start, List<Integer>[] graph, int n) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[n + 1];
        
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : graph[now]) {
                if (!visited[next]) {   
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        return count;
    }
}
