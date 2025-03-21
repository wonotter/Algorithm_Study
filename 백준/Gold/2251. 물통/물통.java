import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 물을 6가지 경우로 붓는 케이스를 표현하기 위한 배열
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; // 물통 A와 B에 담긴 물의 양의 방문 여부
    static boolean[] answer; // A가 비어있을 때 C에 담길 수 있는 물의 양
    static int[] now; // 각 물통의 최대 용량

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }

    public static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;

            // 6가지 붓기 시도를 반복
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[Receiver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;

                // 물통의 용량이 초과하는 경우
                if (next[Receiver[k]] > now[Receiver[k]]) {
                    next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]]; // 초과하는 만큼 이전 물통에 넣어주고
                    next[Receiver[k]] = now[Receiver[k]]; // 대상 물통은 최대치로 채움
                }

                // A와 B의 물의 양을 이용해 방문 배열 체크
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));

                    // 만약 새로운 상태에서 A가 비어있다면 answer 배열에 기록
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}
