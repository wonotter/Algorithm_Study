class Solution {
    public int solution(int[] numbers, int target) {
        return DFS(0, 0, numbers, target);
    }
    
    static int DFS(int idx, int sum, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            
            return 0;
        }
        
        return (DFS(idx + 1, sum + numbers[idx], numbers, target)) + 
            (DFS(idx + 1, sum - numbers[idx], numbers, target));
    }
}
