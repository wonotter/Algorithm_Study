import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Bus>[] A;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        distance = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            A[start].add(new Bus(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start_city = Integer.parseInt(st.nextToken());
        int end_city = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> queue = new PriorityQueue<>();

        queue.add(new Bus(start_city, 0));
        distance[start_city] = 0;

        while (!queue.isEmpty()) {
            Bus current = queue.poll();

            if (visited[current.city]) {
                continue;
            }

            visited[current.city] = true;

            for (int i = 0; i < A[current.city].size(); i++) {
                Bus temp = A[current.city].get(i);

                int nextCity = temp.city;
                int nextCost = temp.cost;

                if (distance[current.city] + nextCost < distance[nextCity]) {
                    distance[nextCity] = distance[current.city] + nextCost;
                    queue.add(new Bus(nextCity, distance[nextCity]));
                }
            }
        }

        System.out.println(distance[end_city]);
    }
}

class Bus implements Comparable<Bus>{
    int city;
    int cost;

    public Bus(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "(" + city + ", " + cost + ")";
    }

    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;
    }
}