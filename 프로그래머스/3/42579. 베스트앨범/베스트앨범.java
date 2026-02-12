import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        ArrayList<String> genresList = new ArrayList<>();
        for (String genre : hashMap.keySet()) {
            genresList.add(genre);
        }
        
        genresList.sort((o1, o2) -> hashMap.get(o2) - hashMap.get(o1));
        
        for (String genre : genresList) {
            PriorityQueue<Song> pq = new PriorityQueue<>();
            
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    pq.add(new Song(plays[i], i));
                }
            }
            
            answer.add(pq.poll().idx);
            
            if (pq.size() != 0) {
                answer.add(pq.poll().idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Song implements Comparable<Song> {
    int plays;
    int idx;
    
    public Song(int plays, int idx) {
        this.plays = plays;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Song o) {
        int c = Integer.compare(o.plays, this.plays);
        if (c != 0) {
            return c;
        }
        
        if (c == 0) {
            return Integer.compare(this.idx, o.idx);
        }
        
        return c;
    }
}
