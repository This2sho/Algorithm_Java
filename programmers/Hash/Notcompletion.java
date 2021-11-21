package programmers.Hash;

import java.util.stream.*;
import java.security.KeyStore.Entry;
import java.util.*;


public class Notcompletion {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String s : participant){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{  
                map.put(s, 0);
            }   
        }
        for(String s : completion){
            if(map.containsKey(s)){
                map.replace(s, map.get(s)-1);
            }
        }
        for(String s : map.keySet()){
            if(map.get(s) >= 0 ){
                answer = s;
                break;
            }
        }
        return answer;
    }
}