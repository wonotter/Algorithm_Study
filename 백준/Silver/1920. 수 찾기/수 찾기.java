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

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;

            boolean result = false;
            while (start <= end) {
                // 중앙값 업데이트를 위해 여기에 선언하는 위치 주의
                int mid = (start + end) / 2;

                // 배열에 있는 중앙값과 찾고자하는 target 값을 비교해야함
                if (A[mid] < target) {
                    start = mid + 1;
                } else if (A[mid] > target) {
                    end = mid - 1;
                } else {
                    result = true;
                    break;
                }
            }

            if (result) System.out.println(1);
            else System.out.println(0);
        }
    }
}
