package programmers.Hash;

import java.util.*;

public class Wejang {
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.solution(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}

class Solution3 {
    /*
        스파이는 하루에 최소 한종류의 옷은 입고
        총 서로 다른 옷의 조합수를 구해야함.
        종류 : A, B, C일 때
        (A + 1) * (B + 1) * (C + 1) -1 을 구하면 됨. 
        (종류를 선택안하는거 빼고 모두 안입을 경우 하나를 더해준거)
    */
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothMap = new HashMap<>();
        for(String[] cloth : clothes){
            String type = cloth[1];
            clothMap.put(type, clothMap.getOrDefault(type, 0)+1);
        }
        for(int clothNum : clothMap.values()){
            answer *= (clothNum+1);
        }
        return answer-1;
    }
}

