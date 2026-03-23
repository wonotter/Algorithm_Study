import java.util.*;

class Solution {
    static int[] parent; // 유니온 파인드 부모 배열
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 유니온 파인드 부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        List<Node> nodes = new ArrayList<>();
        for (int[] cost : costs) {
            nodes.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        nodes.sort((a, b) -> a.weight - b.weight); // 비용 기준 오름차순 정렬
        
        for (Node one : nodes) {
            // 사이클이 생기지 않으면
            if (find(one.from) != find(one.to)) {
                union(one.from, one.to);
                answer += one.weight;
            }
        }
        
        return answer;
    }
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
}

class Node {
    int from;
    int to;
    int weight;
    
    public Node(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
