import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        A = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1)
                    break;
                int dist = Integer.parseInt(st.nextToken());
                A[start].add(new int[]{end, dist});
            }
        }

//        // 배열 확인용 출력
//        for (int i = 1; i < A.length; i++) {
//            for (int[] edge : A[i]) {
//                // 배열 내부의 값을 보기 좋게 출력: [정점,거리]
//                System.out.println(Arrays.toString(edge) + " ");
//            }
//            System.out.println();
//        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        BFS(1);

        int Max = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[Max] < distance[i])
                Max = i;
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        BFS(Max);

        Arrays.sort(distance);
        System.out.println(distance[V]);
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int[] i : A[nowNode]) {
                int end = i[0];
                int dist = i[1];

                if (!visited[end]) {
                    visited[end] = true;
                    queue.add(end);
                    distance[end] = distance[nowNode] + dist;
                }
            }
        }
    }
}
