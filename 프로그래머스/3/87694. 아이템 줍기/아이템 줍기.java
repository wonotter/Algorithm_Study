import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        
        // 모든 직사각형 내부까지 색칠하기
        for (int[] one : rectangle) {
            // 경계를 확실히 남기기 위해 모든 좌표 2배로 늘림
            int x1 = one[0] * 2;
            int y1 = one[1] * 2;
            int x2 = one[2] * 2;
            int y2 = one[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        // 직사각형 테두리만 제외하고 직사각형 내부 경로 제거하기
        for (int[] one : rectangle) {
            // 경계를 확실히 남기기 위해 모든 좌표 2배로 늘림
            int x1 = one[0] * 2;
            int y1 = one[1] * 2;
            int x2 = one[2] * 2;
            int y2 = one[3] * 2;
            
            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    board[y][x] = 0;
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        
        int itemPosX = itemX * 2;
        int itemPosY = itemY * 2;
        
        return BFS(startX, startY, itemPosX, itemPosY, board) / 2;
    }
    
    public static int BFS(int startX, int startY, int itemPosX, int itemPosY, int[][] board) {
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[102][102];
        
        for (int i = 0; i < 102; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        queue.add(new int[]{startX, startY});
        visited[startY][startX] = 0;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            
            if (x == itemPosX && y == itemPosY) {
                return visited[y][x]; 
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (board[ny][nx] == 1 && visited[ny][nx] == -1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
}
