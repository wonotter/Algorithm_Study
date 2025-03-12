import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            A.add(new Node(now, i));
        }

        Collections.sort(A);

        int Max = 0;
        for (int i = 0; i < N; i++) {
            if (Max < A.get(i).index - i)
                Max = A.get(i).index - i;
        }
        System.out.println(Max + 1);
    }
}

class Node implements Comparable<Node>{
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
