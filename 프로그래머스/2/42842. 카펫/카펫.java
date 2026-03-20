class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int h = 1; h * h <= yellow; h++) {
            if (yellow % h == 0) {
                int w = yellow / h;
                
                int totalW = w + 2;
                int totalH = h + 2;
                
                if (brown == (totalW * totalH) - yellow) {
                    answer[0] = totalW;
                    answer[1] = totalH;
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}
