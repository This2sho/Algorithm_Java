package programmers.Hash;

import java.util.stream.*;
import java.util.*;

public class BestElbum_good {
    public static void main(String[] args){
        Solution6 s = new Solution6();
        for(int i :s.solution(new String[] {"classic", "pop", "classic", "classic", "pop", "kpop"},new int[] {500, 600, 150, 800, 2500, 2500})){
            System.out.print(i + " ");
        };
        System.out.println();
    }
}

class Solution6{
    public class Music implements Comparable<Music>{
        String genres;
        int plays;
        int id;

        Music(String genres, int plays, int id){
            this.genres = genres;
            this.plays = plays;
            this.id = id;
        }

        String getGenres(){
            return this.genres;
        }

        @Override
        public int compareTo(Music other) {
            int result = other.plays - this.plays;
            if(result == 0){
                result = this.id - other.id;
            }
            return result;
        }
        @Override
        public String toString() {
            
            return "<genres> : " + genres + " <plays> : " + plays + " <id> : " + id ;
        }
    }

    public int Sum(List<Music> mList){
        int sum = 0;
        for(Music m : mList){
            sum += m.plays;
        }
        return  sum;
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
            .mapToObj(i -> new Music(genres[i], plays[i], i))
            .collect(Collectors.groupingBy(Music::getGenres))
            .entrySet().stream()
            .sorted((m1, m2) -> Sum(m2.getValue()) - Sum(m1.getValue()))
            .flatMap(x -> x.getValue().stream().sorted().limit(2))
            .mapToInt(x->x.id).toArray();
            
    }
    
    
}