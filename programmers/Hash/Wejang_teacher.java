package programmers.Hash;

import java.util.*;
import java.util.stream.*;

public class Wejang_teacher {
    public static void main(String[] args){
        Solution4 s = new Solution4();
        System.out.println(s.solution(new String[][] {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}

class Solution4 {
    /*
        스파이는 하루에 최소 한종류의 옷은 입고
        총 서로 다른 옷의 조합수를 구해야함.
        종류 : A, B, C일 때
        (A + 1) * (B + 1) * (C + 1) -1 을 구하면 됨. 
        (종류를 선택안하는거 빼고 모두 안입을 경우 하나를 더해준거)
    */
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .map(c -> c[1])
            .distinct() // key를 만든거
            .map(type -> (int) Arrays.stream(clothes).filter(c -> c[1].equals(type)).count()+1)
            .reduce(1, (currnetValue, nextValue) -> currnetValue * nextValue) - 1;
    }
}

