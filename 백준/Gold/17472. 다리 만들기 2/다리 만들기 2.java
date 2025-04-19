import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 상, 우, 하, 좌 순서로 탐색
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[] parent;
    static int[][] map;
    static int N, M, sNum; // sNum은 섬의 번호
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mList;

    static PriorityQueue<BEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sNum = 1;
        sumList = new ArrayList<>();
        
        // 각 자리에서 BFS 탐색으로 섬들을 분리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    sNum++;
                    sumList.add(mList);
                }
            }
        }

        // 모든 섬에서 상, 우, 하, 좌 순서로 다리를 지어 다른 섬으로 연결할 수 있는 지 체크
        queue = new PriorityQueue<>();
        for (int i = 0; i < sumList.size(); i++) {
            ArrayList<int[]> now = sumList.get(i);

            for (int j = 0; j < now.size(); j++) {
                int row = now.get(j)[0];
                int col = now.get(j)[1];
                int now_S = map[row][col];

                for (int d = 0; d < 4; d++) {
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int bridge_length = 0;

                    while (row + tempR >= 0 && row + tempR < N && col + tempC >= 0 && col + tempC < M) {
                        if (map[row + tempR][col + tempC] == now_S) // 같은 섬인 경우
                            break;
                        else if (map[row + tempR][col + tempC] != 0) { // 다른 섬인 경우
                            if (bridge_length > 1) { // 다리의 길이가 2 이상인 경우
                                // 우선순위 큐에 새로운 다리 추가
                                queue.add(new BEdge(now_S, map[row + tempR][col + tempC], bridge_length));
                            }
                            break;
                        } else {
                            bridge_length++;
                        }

                        // 상, 하, 좌, 우 방향 중 한 방향으로만 계속 증가시켜 다리를 이어나갈 수 있도록 함
                        if (tempR < 0)
                            tempR--;
                        else if (tempR > 0)
                            tempR++;
                        else if (tempC < 0)
                            tempC--;
                        else if (tempC > 0)
                            tempC++;
                    }
                }
            }
        }

        parent = new int[sNum];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;

        while (!queue.isEmpty()) {
            BEdge now = queue.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }

        // MST를 구성할 때 필요한 다리의 개수 == 섬의 개수 - 1
        // 섬의 개수 == sNum - 1 (BFS를 통해 같은 그룹인 섬의 번호를 다 부여해주고 값을 증가시키기 때문)
        // 다리의 개수 == (sNum - 1) - 1 == sNum - 2
        if (useEdge == sNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    
    static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>();
        int[] start = {i, j};

        queue.add(start);
        mList.add(start);

        visited[i][j] = true;
        map[i][j] = sNum;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int row = now[0];
            int col = now[1];

            for (int d = 0; d < 4; d++) {
                int tempR = dr[d];
                int tempC = dc[d];
                
                while (row + tempR >= 0 && row + tempR < N && col + tempC >= 0 && col + tempC < M) {
                    // 아직 방문하지 않고 and 바다(0)가 아닌 경우 같은 섬으로 취급
                    if (visited[row + tempR][col + tempC] == false && map[row + tempR][col + tempC] != 0) {
                        addNode(row + tempR, col + tempC, queue);
                    }
                    else
                        break;

                    // 특정한 방향으로 탐색 시 인접한 섬이 더 존재하는 확인하기 위해 증감 연산 진행
                    if (tempR < 0)
                        tempR--;
                    else if (tempR > 0)
                        tempR++;
                    else if (tempC < 0)
                        tempC--;
                    else if (tempC > 0)
                        tempC++;
                }
            }
        }
    }

    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;

        int[] temp = {i, j};
        mList.add(temp);
        queue.add(temp);
    }
}

class BEdge implements Comparable<BEdge> {
    int start;
    int end;
    int value;

    public BEdge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(BEdge o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ", " + value + ")";
    }
}
