import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int MOD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^k * 2
        int leftNodeStartIndex = treeSize / 2 - 1; // 2^k - 1
        MOD = 1000000007;

        tree = new long[treeSize + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = 1;
        }

        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(b + leftNodeStartIndex, c);
            } else if (a == 2) {
                b += leftNodeStartIndex;
                c += leftNodeStartIndex;
                System.out.println(getMul(b, (int) c));
            } else {
                return;
            }
        }
        br.close();
    }

    private static long getMul(int b, int c) {
        long partMul = 1;

        // b가 홀수인 경우 부분 곱 진행, c가 짝수인 경우 부분 곱 진행
        while (b <= c) {
            if (b % 2 == 1) {
                partMul = partMul * tree[b] % MOD;
                b++;
            }
            if (c % 2 == 0) {
                partMul = partMul * tree[c] % MOD;
                c--;
            }
            b = b / 2;
            c = c / 2;
        }

        return partMul;
    }

    private static void changeVal(int index, long val) {
        tree[index] = val;

        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}
