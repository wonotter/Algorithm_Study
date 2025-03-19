import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;
    static ArrayList<Integer>[] A;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            A[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        BFS(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                found = true;
                System.out.println(i);
            }
        }

        if (!found) System.out.println(-1);
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int i : A[nowNode]) {
                if (visited[i] == -1) {
                    queue.add(i);
                    visited[i] = visited[nowNode] + 1;
                }
            }
        }
    }
}
