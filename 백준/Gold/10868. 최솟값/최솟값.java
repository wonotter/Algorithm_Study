import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;

        // 2^k >= N을 만족하는 k의 최솟값을 구하기
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        // 2^k * 2를 트리 배열의 크기로 정의
        int treeSize = (int) Math.pow(2, treeHeight + 1);

        // 2^k - 1이 리프 노드에서 0번째 인덱스
        // 실제로 리프 노드는 2^k부터 채워넣음
        int leftNodeStartIndex = treeSize / 2 - 1;
        
        // 트리를 최댓값으로 초기화
        tree = new long[treeSize + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        // 리프 노드 시작 점인 2^k 부터 값을 채워넣어야 함
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 트리의 마지막 인덱스부터 시작
        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start += leftNodeStartIndex;
            end += leftNodeStartIndex;

            System.out.println(getMin(start, end));
        }
        br.close();
    }

    private static long getMin(int start, int end) {
        long Min = Long.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) {
                Min = Math.min(Min, tree[start]);
                start++;
            }
            start = start / 2;

            if (end % 2 == 0) {
                Min = Math.min(Min, tree[end]);
                end--;
            }
            end = end / 2;
        }

        return Min;
    }

    // 왼쪽과 오른쪽 자식 중 더 작은 값을 부모 노드로 설정
    private static void setTree(int i) {
        while (i != 1) {
            if (tree[i / 2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }
}
