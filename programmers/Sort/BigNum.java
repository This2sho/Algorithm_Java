package programmers.Sort;

import java.util.*;

public class BigNum {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {3, 30, 34, 5, 9}));
    }
}

/**
 * !! 두 문자열을 더해서 비교할 생각을 못했음 
 * + Comparator를 구현할줄 몰랐음...(Stream작성하다 망함.)
 * 그리고 마지막 0으로 시작할ㄷ 때 예외처리도....
 */
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        for(int i=0; i<strArr.length; i++){
            strArr[i] = "" + numbers[i];
        }
        Arrays.sort(strArr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(String s : strArr){
            answer += s;
        }
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
