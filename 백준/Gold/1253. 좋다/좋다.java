import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int count = 0;

        for (int k = 0; k < N; k++) {
            int start_idx = 0;
            int end_idx = N - 1;

            while (start_idx < end_idx) {
                if (A[start_idx] + A[end_idx] == A[k]) {
                    if (start_idx != k && end_idx != k) {
                        count++;
                        break;
                    } else if (start_idx == k) {
                        start_idx++;
                    } else {
                        end_idx--;
                    }
                } else if (A[start_idx] + A[end_idx] < A[k]) {
                    start_idx++;
                } else {
                    end_idx--;
                }
            }
        }

        System.out.println(count);
    }
}
