import java.util.*;

class Solution {
    static Set<String> result = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        
        DFS(0, new ArrayList<>(), user_id, banned_id);
        
        return result.size();
    }
    
    public static void DFS(int depth, List<String> selected, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            // 순서 제거를 위해 정렬
            List<String> temp = new ArrayList<>(selected);
            Collections.sort(temp);
            
            // 하나의 문자열로 저장
            String key = String.join(",", temp);
            
            result.add(key);
            return;
        }
        
        // banned_id 1개씩 순서대로 들고오기
        String banned = banned_id[depth];
        
        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            // 패턴이 일치하지 않는 경우
            if (!match(user_id[i], banned)) {
                continue;
            }
            
            // 방문 처리
            visited[i] = true;
            selected.add(user_id[i]);
            
            DFS(depth + 1, selected, user_id, banned_id);
            
            // 백트래킹
            visited[i] = false;
            selected.remove(selected.size() - 1);
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
