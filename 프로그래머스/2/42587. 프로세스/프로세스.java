import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node(priorities[i], i));
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            boolean hasHigher = false;
            for (Node next : queue) {
                if (cur.priority < next.priority) {
                    hasHigher = true;
                    queue.add(cur);
                    break;
                }
            }
            
            if (!hasHigher) {
                count++;
                
                if (cur.idx == location) {
                    return count;
                }
            }
        }
        
        return count;
    }
}

class Node {
    int priority;
    int idx;
    
    public Node(int priority, int idx) {
        this.priority = priority;
        this.idx = idx;
    }
}
