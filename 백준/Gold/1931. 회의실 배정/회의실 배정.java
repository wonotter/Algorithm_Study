import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Conference> conf = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.end == o2.end) {
                        return o1.start - o2.start;
                    }
                    return o1.end - o2.end;
                });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            conf.add(new Conference(start, end));
        }

        int count = 0;
        int currentEndTime = 0;
        while (!conf.isEmpty()) {
            Conference now = conf.poll();

            if (now.start >= currentEndTime) {
                count++;
                currentEndTime = now.end;
            }
        }

        System.out.println(count);
    }
}

class Conference {
    int start;
    int end;

    public Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
