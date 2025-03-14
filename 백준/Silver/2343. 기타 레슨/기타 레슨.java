import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = Arrays.stream(A).max().getAsInt();
        int end = Arrays.stream(A).sum();

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}
