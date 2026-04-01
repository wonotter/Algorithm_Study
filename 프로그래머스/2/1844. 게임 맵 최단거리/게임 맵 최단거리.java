import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = BFS(maps, 
                   new int[]{0, 0}, 
                   new int[]{maps.length - 1, maps[0].length - 1}
                  );
        
        if (answer == -1) {
            return answer;
        } else {
            return answer + 1;
        }
    }
    
    public static int BFS(int[][] maps, int[] start, int[] end) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == end[0] && y == end[1]) {
                return visited[x][y];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || 
                    maps[nx][ny] == 0 || visited[nx][ny] > 0) {
                    continue;
                }
                
                visited[nx][ny] = visited[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
        
        return -1;
    }
}
