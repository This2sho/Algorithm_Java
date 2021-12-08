package programmers.Hash;

import java.util.*;

public class Phonw_pre {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.solution(new String[] {"119", "97674223", "1195524421"}));
    }
}
/**
 * 길이 1~20
 * String.startswith 접두사찾기
 * 배열의 크기 10*e^6
 * for문 한번 돌기 가능
 * + for문안에 20번 돌기 가능(전화번호 최대 길이 만큼)
 * 
 * 보통 이면 2중 for문으로
 * string 한번 돌고 다음 for문으로 한번 돌아서 찾는데
 * 
 */

class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<Integer, ArrayList<String>>  hMap = new HashMap<>();
        Arrays.sort(phone_book, (s1, s2) ->  s1.length() - s2.length());
        for (String s : phone_book){
            System.out.println(s);
        }
        
    
        
        return answer;
    }
}