import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (String phoneNumber : phone_book) {
            hashMap.put(phoneNumber, phoneNumber.length());
        }
        
        for (String phoneNumber : phone_book) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (hashMap.containsKey(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
