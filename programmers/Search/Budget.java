package programmers.Search;

import java.util.*;
import java.util.stream.*;

public class Budget {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {120, 110, 140, 150}, 485));
    }
}
 /**
 * 초기 예산보다 작거나 같은것들은
 * 총예산에서 각 예산을 빼준다.(남은 예산)
 * 
 * 초과하는 것들은
 * 남은 예산에서 초기예산으로 계산하여 빼준다.(남은 예산)
 * 
 * 초기 예산에서 1씩 더해준다. (초기 예산)
 * 
 * 초기 예산보다 작거나 같은것들은
 * 남은 예산에서 초기 예산만큼 빼준다.
 * 
 * 초기예산에서 1씩 더했을때 만약 남은예산이 0보다 작아지면 이전 값으로
 * 초기예산을 반환한다.
 */
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int max = IntStream.of(budgets).max().orElse(0); // 150
        int min = 0;

        long sum = 0;
        for(int b : budgets) sum += b;
        if(sum <= M) return max;

        while(max >= min){
            final int mid = (max + min) / 2;

            sum = IntStream.of(budgets)
                    .map(b -> Math.min(b, mid))
                    .sum();

            if(sum <= M){
                min = mid + 1;
                answer = mid;
            }else max = mid - 1;
        }

        return answer;
    }
}

// 110 120 140 150 (sort)
// 