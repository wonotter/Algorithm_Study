import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // BufferedReader 클래스의 readLine() 메서드가 IOException을 throws 하고 있음
    // 따라서 main 함수도 예외 처리를 JVM에 넘기기 위해 throws IOException 선언 필요
    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리를 위해 BufferedReader 사용
        // 바이트 스트림을 문자 스트림으로 변환하기 위해 InputStreamReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 특정 구분자(default 공백)를 기준으로 토큰화 해주는 StringTokenizer 사용
        // 한 줄씩 읽어서 String 형태로 반환하는 readLine() 메서드
        StringTokenizer st = new StringTokenizer(br.readLine());

        // nextToken()을 통해 구분자를 기준으로 토큰화된 문자열들을 하나씩 들고옴
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());

        // N + 1 크기의 배열 선언
        long[] S = new long[suNo + 1];
        st = new StringTokenizer(br.readLine());

        // 읽어들인 토큰(입력받은 배열)을 누적하여 더하며 합배열 생성
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        // 요청하는 구간합에 따라 구간 합을 구하여 정답 출력
        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
