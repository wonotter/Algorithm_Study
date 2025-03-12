import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 동, 남, 서, 북을 탐색하기 위한 배열 선언
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited; // 미로 방문여부 체크를 위한 2차원 배열
    static int[][] A; // 미로를 저장하기 위한 2차원 배열
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            
            // 값을 붙여서 입력받았으므로 substring(start_idx, end_idx - 1)을 통해 하나씩 저장
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j}); // 시작 좌표를 push
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            // 현재 위치좌표의 노드를 꺼냄
            int[] nowNode = queue.poll();

            // 동, 남, 서, 북 기준으로 반복
            for (int k = 0; k < 4; k++) {
                // x, y는 반복문이 돌며 동, 남, 서, 북으로 이동한 좌표를 나타냄
                int x = nowNode[0] + dx[k];
                int y = nowNode[1] + dy[k];

                // 미로 크기에 벗어나지 않고 이동할 수 있는 좌표이면서
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // 0이 아니라서 이동할 수 있는 좌표이면서
                    // 아직 방문하지 않은 경우
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[nowNode[0]][nowNode[1]] + 1; // 이동할 좌표에 +1 더함
                        queue.add(new int[]{x, y}); // 이동한 좌표 push
                    }
                }
            }
        }
    }
}
