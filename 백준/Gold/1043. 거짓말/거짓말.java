import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static int[] truthP;
    static ArrayList<Integer>[] party;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int truth = sc.nextInt();

        result = 0;
        truthP = new int[truth];

        for (int i = 0; i < truth; i++) {
            truthP[i] = sc.nextInt();
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            int party_size = sc.nextInt();

            for (int j = 0; j < party_size; j++) {
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isPossible = true;

            int cur = party[i].get(0);
            for (int j = 0; j < truthP.length; j++) {
                if (find(cur) == find(truthP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible)
                result++;
        }

        System.out.println(result);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
