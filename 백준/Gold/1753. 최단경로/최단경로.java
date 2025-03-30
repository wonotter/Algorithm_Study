import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Vertex>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        A = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
        }

        distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[u].add(new Vertex(v, w));
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        queue.add(new Vertex(K, 0));
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            int curNode = current.node;

            if (visited[curNode])
                continue;

            visited[curNode] = true;

            for (int i = 0; i < A[curNode].size(); i++) {
                Vertex temp = A[curNode].get(i);
                int nextNode = temp.node;
                int weight = temp.weight;

                if (distance[curNode] + weight < distance[nextNode]) {
                    distance[nextNode] = distance[curNode] + weight;
                    queue.add(new Vertex(nextNode, distance[nextNode]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Vertex implements Comparable<Vertex> {
    int node;
    int weight;

    public Vertex(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    // toString()을 재정의하여 간선 정보를 보기 좋게 출력
    @Override
    public String toString() {
        return "(" + node + ", " + weight + ")";
    }

    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}