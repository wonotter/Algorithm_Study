import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer;
    static int root;
    static int deleteNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            tree[i].add(parent);
            tree[parent].add(i);
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int v) {
        visited[v] = true;
        int cNode = 0;

        for (int i : tree[v]) {
            if (!visited[i] && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }
        if (cNode == 0)
            answer++;
    }
}
