import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (end != N) {
            if (sum == N){
                end++;
                sum += end;
                count++;
            }
            else if (sum < N) {
                end++;
                sum += end;
            }
            else if (sum > N) {
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
