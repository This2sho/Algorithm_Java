package programmers.Search;

import java.util.stream.*;

public class Budget_teacher {
    public static void main(String[] args){
        Solution2 s = new Solution2();
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
class Solution2 {
    public int solution(int[] budgets, int M) {
        int min = 0;
        int max = IntStream.of(budgets).max().orElse(1);

        while(min <= max){
            int mid = (max + min) / 2;
            int sum = 0;
            for(int budget : budgets){
                if(budget <= mid){
                    sum += budget;
                }else{
                    sum += mid;
                }
            }
            
            if(sum > M){
                max = mid-1;
            }else min = mid+1;
        }
        return max;
    }
}

// 110 120 140 150 (sort)
// 