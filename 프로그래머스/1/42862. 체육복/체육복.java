import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> llost = new ArrayList<>();
        llost = Arrays.stream(lost).boxed().collect(Collectors.toList());
        
        List<Integer> lreserve = new ArrayList<>();
        lreserve = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        Collections.sort(llost);
        Collections.sort(lreserve);
        
        for (int i = 0; i < lreserve.size(); i++) {
            for (int j = 0; j < llost.size(); j++) {
                if (lreserve.get(i) == llost.get(j)) {
                    lreserve.remove(i);
                    llost.remove(j);
                    i--;
                    break;
                }
            }
        }
        
        for (int num : lreserve) {
            for (int i = 0; i < llost.size(); i++) {
                int lostStudent = llost.get(i);
                
                if ((num + 1) == lostStudent || (num - 1) == lostStudent) {
                    llost.remove(i);
                    break;
                }
            }
        }
        
        return n - llost.size();
    }
}
