import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Nodes>[] A;
    static PriorityQueue<Integer>[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        distance = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            distance[i] = new PriorityQueue<>(k, Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A[a].add(new Nodes(b, c));
        }

        PriorityQueue<Nodes> queue = new PriorityQueue<>();

        queue.add(new Nodes(1, 0));
        distance[1].add(0);

        while (!queue.isEmpty()) {
            Nodes current = queue.poll();

            int curEnd = current.end;
            int curWeight = current.weight;

            for (int i = 0; i < A[current.end].size(); i++) {
                Nodes temp = A[current.end].get(i);

                int nextEnd = temp.end;
                int nextWeight = temp.weight;

                // 아직 해당 노드의 후보 경로 개수가 k개 미만이면 무조건 추가
                if (distance[nextEnd].size() < k) {
                    distance[nextEnd].add(curWeight + nextWeight);
                    queue.add(new Nodes(nextEnd, current.weight + nextWeight));
                }

                // 만약 k개의 경로가 이미 존재한다면, 존재하는 값들 중 가장 큰 값 보다 새로운 경로가 더 작으면 교체
                else if (distance[nextEnd].peek() > curWeight + nextWeight) {
                    distance[nextEnd].poll();
                    distance[nextEnd].add(curWeight + nextWeight);
                    queue.add(new Nodes(nextEnd, curWeight + nextWeight));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i].size() == k) {
                bw.write(distance[i].peek() + "\n");
            } else {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Nodes implements Comparable<Nodes> {
    int end;
    int weight;

    public Nodes(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + end + ", " + weight + ")";
    }

    @Override
    public int compareTo(Nodes o) {
        return this.weight - o.weight;
    }
}
