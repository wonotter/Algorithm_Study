import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

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
        tree = new long[treeSize + 1];

        // 리프 노드 시작 점인 2^k 부터 값을 채워넣어야 함
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            // 질의 인덱스를 세그먼트 트리 인덱스로 변환
            // 세그먼트 트리 인덱스 == 질의 인덱스 + 2^k - 1
            if (a == 1) {
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) {
                s = s + leftNodeStartIndex;
                e = e + leftNodeStartIndex;
                System.out.println(getSum(s, (int) e));
            } else {
                return;
            }
        }
        br.close();
    }
    
    private static long getSum(int s, int e) {
        long partSum = 0;

        // s가 홀수인 경우 부분 합을 더해주고, e가 짝수인 경우 부분 합을 더해줌
        while (s <= e) {
            if (s % 2 == 1) {
                partSum = partSum + tree[s];
                s++;
            }
            if (e % 2 == 0) {
                partSum = partSum + tree[e];
                e--;
            }
            s = s / 2;
            e = e / 2;
        }

        return partSum;
    }

    private static void changeVal(int index, long val) {
        // 값 변경을 위해 주어진 값과 기존 값의 차이(diff)를 구함
        long diff = val - tree[index];

        // 변경한 리프 노드 시점부터 부모 노드에 접근하면서 차이(diff)를 더해줌
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }

    // 리프 노드들의 누적합을 구하여 부모 인덱스 노드에 대입하기
    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
