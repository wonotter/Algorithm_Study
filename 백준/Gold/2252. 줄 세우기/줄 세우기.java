import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] entry;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        entry = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            arr[A].add(B);
            entry[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (entry[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            answer.add(node);
            for (int next : arr[node]) {
                entry[next]--;
                if (entry[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
