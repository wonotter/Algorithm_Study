import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < k)
                start = mid + 1;
            else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
