package programmers;

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
        Arrays.sort(budgets);
        int sum = 0;
        int budget = M/budgets.length;
        int remain_budget = M;
        int max = budgets[budgets.length-1];
        max = IntStream.of(budgets).max().orElse(0);
        // Queue<Integer> q = new LinkedList<>();
        
        for(int b : budgets){
            sum += b;
            // q.offer(b);
        }

        if(M >= sum){
            return max;
        }

        int idx = 0;
        int lastIdx = budgets.length;
        // while(!q.isEmpty() && remain_budget > budget*q.size()){
        //     if(q.peek() < budget){
        //         remain_budget -= q.poll();
        //     }
        //     budget++;
        // }

        while(idx<lastIdx && remain_budget > budget*(lastIdx-idx)){
            if(budgets[idx] < budget){
                remain_budget -= budgets[idx++];
            }
            budget++;
        }
        budget--;
        answer = budget;     
        return answer;
    }
}

// 110 120 140 150 (sort)
// 