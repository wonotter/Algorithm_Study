import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] A = new long[N + 1];
        long[] S = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] +  A[i];
        }

        long[] C = new long[M];
        long answer = 0;

        for (int i = 1; i <= N; i++) {
            int remainder = (int) (S[i] % M);

            if (remainder == 0)
                answer++;

            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer += (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}
