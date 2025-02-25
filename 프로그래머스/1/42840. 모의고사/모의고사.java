import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            // 2차원 배열에서 length는 row의 길이
            for (int j = 0; j < pattern.length; j++) {
                // 원형 큐를 구현하는 것과 동일한 원리로 나머지셈 연산 진행
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}