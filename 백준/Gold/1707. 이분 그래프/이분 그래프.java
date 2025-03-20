import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int[] check;
    static boolean IsBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int t = 0; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<>();
            }
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsBipartite = true;

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                A[start].add(end);
                A[end].add(start);
            }

            for (int i = 1; i <= V; i++) {
                if (IsBipartite)
                    DFS(i);
                else
                    break;
            }

            if (IsBipartite) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static void DFS(int v) {
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                check[i] = (check[v] + 1) % 2;
                DFS(i);
            } else if (check[v] == check[i]) {
                IsBipartite = false;
            }
        }
    }
}
