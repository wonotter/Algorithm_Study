import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();

        StringBuilder bf = new StringBuilder();
        int num = 1;
        boolean result = true;

        for (int i : A) {
            if (i >= num) {
                while (i >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }

            else {
                int next = stack.pop();

                if (i < next) {
                    System.out.println("NO");
                    result = false;
                    break;
                }

                else {
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf);
    }
}
