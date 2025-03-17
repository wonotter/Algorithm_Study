import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0)
                zero++;

            else if (input == 1)
                one++;

            else if (input < 0) {
                minus.add(input);
            }
            else {
                plus.add(input);
            }
        }

        int answer = 0;
        while (plus.size() > 1) {
            int first = plus.poll();
            int second = plus.poll();

            answer += first * second;
        }

        if (!plus.isEmpty()) {
            answer += plus.poll();
        }

        while (minus.size() > 1) {
            int first = minus.poll();
            int second = minus.poll();

            answer += first * second;
        }

        if (!minus.isEmpty()) {
            if (zero < 1) {
                answer += minus.poll();
            }
        }

        answer += one;

        System.out.println(answer);
    }
}
