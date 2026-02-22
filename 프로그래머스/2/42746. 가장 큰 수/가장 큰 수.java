import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] newNumbers = new String[numbers.length];
        
        for (int i = 0; i < newNumbers.length; i++) {
            newNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(newNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (newNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newNumbers.length; i++) {
            sb.append(newNumbers[i]);
        }
        
        return sb.toString();
    }
}
