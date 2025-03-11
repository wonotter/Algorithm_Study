import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static boolean isPrime(int num) {
        if (num == 2) return true;
        else if (num < 2) return false;
        else if (num % 2 == 0) return false;

        double sqrt_num = Math.sqrt(num);

        for (int i = 3; i <= sqrt_num; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    static void DFS(int num, int count) {
        if (count == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) continue;

            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, count + 1);
            }
        }
    }
}
