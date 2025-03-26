import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        int[] entry = new int[N + 1];
        int[] times = new int[N + 1];

        for (int i = 1; i <=N; i++) {
            A[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int nodes = Integer.parseInt(st.nextToken());

                if (nodes == -1)
                    break;

                A[nodes].add(i);
                entry[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (entry[i] == 0) {
                queue.add(i);
            }
        }

        int[] answer = new int[N + 1];
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : A[node]) {
                entry[i]--;

                answer[i] = Math.max(answer[i], answer[node] + times[node]);
                if (entry[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(answer[i] + times[i]);
        }
    }
}
