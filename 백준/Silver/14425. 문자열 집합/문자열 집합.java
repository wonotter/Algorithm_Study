import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        tNode root = new tNode();
        while (N > 0) {
            String text = sc.next();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                // next는 tNode를 가진 길이가 26인 배열
                // 'a' - 'a' == 0, 'b' - 'a' == 1, 'c' - 'a' == 2 방식
                // 해당 문자가 알파벳 순서 상 몇 번째인지 나타내는 정수
                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }

                now = now.next[c - 'a'];

                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            N--;
        }

        int count = 0;
        while (M > 0) {
            String text = sc.next();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (now.next[c - 'a'] == null) {
                    break;
                }

                now = now.next[c - 'a'];

                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }
            M--;
        }

        System.out.println(count);
    }
}

class tNode {
    tNode[] next = new tNode[26];
    boolean isEnd;
}
