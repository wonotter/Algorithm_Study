import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N, M;
    static int[] trust;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        trust = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int Max = 0;
        for (int i = 1; i <= N; i++) {
            Max = Math.max(Max, trust[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (Max == trust[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int i : A[nowNode]) {
                if (!visited[i]) {
                    queue.add(i);
                    trust[i]++;
                    visited[i] = true;
                }
            }
        }
    }
}
