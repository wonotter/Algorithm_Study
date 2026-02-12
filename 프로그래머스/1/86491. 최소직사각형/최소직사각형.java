import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                row.add(size[0]);
                col.add(size[1]);
            } else {
                row.add(size[1]);
                col.add(size[0]);
            }
        }
        
        int maxRow = row.stream().mapToInt(i -> i).max().orElse(0);
        int maxCol = col.stream().mapToInt(i -> i).max().orElse(0);
        
        answer = maxRow * maxCol;
        
        return answer;
    }
}
