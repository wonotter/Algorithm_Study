import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        
        PriorityQueue<Tangerine> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.amount == o2.amount) {
                return o1.amount - o2.amount;
            }
            
            return o2.amount - o1.amount;
        });
        
        int flag = tangerine[0];
        int count = 0;
        for (int i = 0; i < tangerine.length; i++) {
            if (flag == tangerine[i]) {
                count++;
            } else {
                pq.add(new Tangerine(tangerine[i - 1], count));
                
                flag = tangerine[i];
                count = 1;
            }
        }
        
        pq.add(new Tangerine(tangerine[tangerine.length - 1], count));
        
        Tangerine top = pq.peek();
        if (top.amount > k) {
            return 1;
        }
        
        int answer = 0;
        while (k > 0) {
            Tangerine oneType = pq.poll();
            int oneAmount = oneType.amount;
            
            k -= oneAmount;
            answer++;
        }
        
        return answer;
    }
}

class Tangerine {
    int size;
    int amount;
    
    public Tangerine(int size, int amount) {
        this.size = size;
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return "size=" + size + "," + "amount=" + amount;
    }
}
