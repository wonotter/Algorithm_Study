import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int start_city = Integer.parseInt(st.nextToken());
        int end_city = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Transport[] transport = new Transport[M];
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MIN_VALUE);

        long[] money_city = new long[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            transport[i] = new Transport(start, end, price);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money_city[i] = Integer.parseInt(st.nextToken());
        }

        // 벨만-포드 알고리즘 수행
        distance[start_city] = money_city[start_city];
        for (int i = 0; i < N + 50; i++) {
            for (int j = 0; j < M; j++) {
                Transport tr = transport[j];

                if (distance[tr.start] == Long.MIN_VALUE)
                    continue;

                else if (distance[tr.start] == Long.MAX_VALUE) {
                    distance[tr.end] = Long.MAX_VALUE;
                }

                else if (distance[tr.end] < distance[tr.start] + money_city[tr.end] - tr.price) {
                    distance[tr.end] = distance[tr.start] + money_city[tr.end] - tr.price;

                    if (i >= N - 1) {
                        distance[tr.end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (distance[end_city] == Long.MIN_VALUE)
            System.out.println("gg");
        else if (distance[end_city] == Long.MAX_VALUE)
            System.out.println("Gee");
        else
            System.out.println(distance[end_city]);
    }
}

class Transport {
    int start;
    int end;
    int price;

    public Transport(int start, int end, int price) {
        this.start = start;
        this.end = end;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ", " + price + ")";
    }
}
