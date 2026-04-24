import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        DFS(numbers, "");
        
        int answer = 0;
        
        for (int number : set) {
            if (isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void DFS(String numbers, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            DFS(numbers, current + numbers.charAt(i));
            
            // 백트래킹으로 완전탐색 진행
            visited[i] = false;
        }
    }
    
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
