import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        char[] nameAlphabet = name.toCharArray();
        
        // 상하 이동
        for (char alpha : nameAlphabet) {
            int baseMove = alpha - 'A';
            
            if (baseMove == 0) {
                continue;
            } else if (baseMove > 13) { // N을 초과한 알파벳인 경우 (아래 방향키 이동)
                answer += 26 - baseMove;
            } else {
                answer += baseMove;
            }
        }
        
        // 좌우 이동
        int minMove = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            
            while (next < name.length() && nameAlphabet[next] == 'A') {
                next++;
            }
            
            // 여기서부터는 next가 A가 연속으로 아닌 첫 알파벳 지점
            // ABAACB면 C 지점
            int firstMethod = i * 2 + (name.length() - next);
            int secondMethod = (name.length() - next) * 2 + i;
            
            minMove = Math.min(minMove, Math.min(firstMethod, secondMethod));
        }
        return answer + minMove;
    }
}
