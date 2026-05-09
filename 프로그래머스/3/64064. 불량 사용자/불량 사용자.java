import java.util.*;

class Solution {
    static Set<Integer> result = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        DFS(0, 0, user_id, banned_id);
        
        return result.size();
    }
    
    public static void DFS(int depth, int bit, String[] user_id, String[] banned_id) {
        // 모든 banned_id 처리
        if (depth == banned_id.length) {
            result.add(bit);
            return;
        }
        
        String banned = banned_id[depth];
        
        for (int i = 0; i < user_id.length; i++) {
            
            // ex. bit = 0 1 0 0 1, i = 0
            // 0 1 0 0 1 & 0 0 0 0 1 == 0 0 0 0 1 이므로
            // & 연산 결과가 0이 아니면 i는 이미 선택한 user라는 의미
            if ((bit & (1 << i)) != 0) {
                continue;
            }
            
            if (!match(user_id[i], banned)) {
                continue;
            }
            
            // 값에 의한 복사로 비트를 전달하기 때문에 백트래킹 과정이 필요 없음
            // ex. bit = 0, depth = 0 => DFS(0, 0) 상태 
            // => DFS(0 + 1, 0 | (1 << 0))
            // => DFS(1, 1) // 2번째 1은 값 복사로 넘어감
            // DFS 호출이 끝나면 다시 DFS(0, 0) 상태로 돌아온다는 뜻
            DFS(depth + 1, bit | (1 << i), user_id, banned_id);
        }
    }
    
    public static boolean match(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        
        for (int i = 0; i < user.length(); i++) {
            char b = banned.charAt(i);
            
            if (b == '*') {
                continue;
            }
            
            if (user.charAt(i) != b) {
                return false;
            }
        }
        
        return true;
    }
}
