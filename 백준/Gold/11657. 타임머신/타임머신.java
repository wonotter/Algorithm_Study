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

        Edges[] edges = new Edges[M + 1];
        long[] distances = new long[N + 1];

        Arrays.fill(distances, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Edges(A, B, C);
        }

        // 벨만-포드 알고리즘 수행
        distances[1] = 0;
        for (int i = 1; i < N; i++) { // N - 1만틈 반복
            for (int j = 0; j < M; j++) {
                Edges edge = edges[j];

                // 더 작은 최단거리가 있을 때 업데이트
                if (distances[edge.start] != Integer.MAX_VALUE
                        && distances[edge.end] > distances[edge.start] + edge.value) {
                    distances[edge.end] = distances[edge.start] + edge.value;
                }
            }
        }

        boolean mCycle = false;
        for (int i = 0; i < M; i++) { // 음수 사이클 확인
            Edges edge = edges[i];

            if (distances[edge.start] != Integer.MAX_VALUE
                    && distances[edge.end] > distances[edge.start] + edge.value) {
                mCycle = true;
            }
        }

        if (!mCycle) { // 음의 사이클이 없을 때
            for (int i = 2; i <= N; i++) {
                if (distances[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distances[i]);
                }
            }
        } else { // 음의 사이클이 있을 때
            System.out.println("-1");
        }
    }
}

class Edges {
    int start;
    int end;
    int value;

    public Edges(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
