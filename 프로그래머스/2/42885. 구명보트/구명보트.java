import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            } else if (people[right] + people[left] > limit) {
                right -= 1;
                answer++;
            } else if (people[right] + people[left] <= limit) {
                left += 1;
                right -= 1;
                answer++;
            }
        }
        
        return answer;
    }
}
