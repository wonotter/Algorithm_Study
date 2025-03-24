import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int op = sc.nextInt();

            int a = sc.nextInt();
            int b = sc.nextInt();

            if (op == 0)
                union(a, b);
            else {
                if (checkSame(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[a] = b;
        }
    }

    static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return true;

        return false;
    }
}
