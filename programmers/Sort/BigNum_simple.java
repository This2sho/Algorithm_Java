package programmers.Sort;

import java.util.stream.*;

public class BigNum_simple {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[] {3, 30, 34, 5, 9}));
    }
}

/**
 * !! 두 문자열을 더해서 비교할 생각을 못했음 
 * + Comparator를 구현할줄 몰랐음...(Stream작성하다 망함.)
 * 그리고 마지막 0으로 시작할때 예외처리도....
 */
class Solution2 {
    public String solution(int[] numbers) {
        String answer = "";

        // 이 부분은 Stream으로 처리하는게 깔끔.
        // String[] strArr = new String[numbers.length];
        // for(int i=0; i<strArr.length; i++){
        //     strArr[i] = "" + numbers[i];
        // }

        answer = IntStream.of(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
            .collect(Collectors.joining());

        // 이 부분은 자바8 이상부터 람다로 가능
        // Arrays.sort(strArr, new Comparator<String>(){
        //     public int compare(String s1, String s2){
        //         return (s2+s1).compareTo(s1+s2);
        //     }
        // });
        // Arrays.sort(strArr, (s1, s2) ->
        //     (s2+s1).compareTo(s1+s2));

        // for(String s : strArr){
        //     answer += s;
        // }
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}
