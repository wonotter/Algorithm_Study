class Solution {
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        max = -1;
        boolean[] visited = new boolean[8];
        DFS(k, 0, dungeons, visited);
        
        return max;
    }
    
    public static void DFS(int k, int count, int[][] dungeons, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                DFS(k - dungeons[i][1], count + 1, dungeons, visited);
                visited[i] = false;
            }
        }
        
        max = Math.max(max, count);
    }
}
