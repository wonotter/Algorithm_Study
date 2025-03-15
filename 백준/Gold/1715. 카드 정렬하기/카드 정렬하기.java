import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            int result = first + second;
            answer += result;

            queue.offer(result);
        }

        System.out.println(answer);
    }
}
