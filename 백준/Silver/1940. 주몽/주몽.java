import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(arr);

        int count = 0;
        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (arr[i] + arr[j] < M) {
                i++;
            }
            else if (arr[i] + arr[j] > M) {
                j--;
            }
            else {
                count++;
                i++; j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
