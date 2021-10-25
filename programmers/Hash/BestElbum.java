package programmers.Hash;

import java.util.*;
import java.util.stream.*;


public class BestElbum {
    public static void main(String[] args){
        Solution5 s = new Solution5();
        for(int i :s.solution(new String[] {"classic", "pop", "classic", "classic", "pop", "kpop"},new int[] {500, 600, 150, 800, 2500, 2500})){
            System.out.print(i + " ");
        };
        System.out.println();
    }
}

class Solution5 {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            
            LinkedHashMap<String, ArrayList<Music>> musicMap = new LinkedHashMap<>();
            LinkedHashMap<String, Integer> playSumMap = new LinkedHashMap<>();
            
            // musicMap 완성 (넣기는 완성)
            // playSum 완성 (넣기는 완성)
            // todo 
            // 1. playSum value별 내림차순 정렬
            // 2. musicMap에도 각 value를 play별 순위 정렬후 교체
            // 3. playSum에 있는 key순으로 musicMap에 꺼내서 최대 2개까지 꺼내서 answer에 담아야함.
            
            for(int id=0; id<genres.length; id++){
                Music tempMusic = new Music(genres[id], plays[id], id);
                if(musicMap.containsKey(genres[id])){
                    musicMap.get(genres[id]).add(tempMusic);
                    int playSum = playSumMap.get(genres[id]);
                    playSumMap.replace(genres[id], playSum+plays[id]);
                }else{
                    ArrayList<Music> tempList = new ArrayList<>();
                    tempList.add(tempMusic);
                    musicMap.put(genres[id], tempList);
                    playSumMap.put(genres[id], plays[id]);
                }
            }
            LinkedHashMap<String, Integer> sumResult = null;

            sumResult = playSumMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(v1, v2)->v1, LinkedHashMap::new));//Map.Entry::getKey, Map.Entry::getValue));
            
            for(ArrayList<Music> musiclist : musicMap.values()){
                ArrayList<Music> temp = musiclist.stream()
                        .sorted((m1, m2) -> {
                            int result = m2.getPlays() - m1.getPlays();
                            if(result == 0){
                                result = m1.getId() - m2.getId();
                            }
                            return result;
                        })
                        .collect(Collectors.toCollection(ArrayList::new));
                musicMap.replace(temp.get(0).getGenres(), temp);
            }
            List<Integer> resulstList = new ArrayList<>();
            
            for(Object s : sumResult.keySet().toArray()){
                ArrayList<Music> temp = musicMap.get(s);
                int size = 2;
                if(temp.size() < 2){
                    size = temp.size();
                }
                for(int i=0; i < size; i++){
                    resulstList.add(temp.get(i).getId());
                }
            }
            answer = new int[resulstList.size()];
            for(int i=0; i < resulstList.size(); i++){
                answer[i] = resulstList.get(i);
            }
            return answer;
        }

    class Music{
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
        int getPlays(){
            return this.plays;
        }
        int getId(){
            return this.id;
        }
    }
}
