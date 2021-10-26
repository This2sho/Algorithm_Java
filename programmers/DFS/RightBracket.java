package programmers.DFS;

import java.util.*;

public class RightBracket {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(3));
    }
    static class Solution {
        class P{
            int open;
            int close;
            P(int open, int close){
                this.open = open;
                this.close = close;
            }
        }
        
        /*
            조건 
            1. close가 open보다 크면 안된다.
            2. open과 close의 합은 n*2
            3. 
        */
        public int solution(int n) {
            int answer = 0;
            Stack<P> stack = new Stack<>();
            P p = new P(0, 0);
            stack.add(p);
            
            while(!stack.isEmpty()){
                P current = stack.pop();
                if(current.close > current.open) continue;
                if(current.open + current.close == n*2){
                    answer++;
                    continue;
                }
                if(current.open + 1 <= n) stack.add(new P(current.open+1, current.close));
                if(current.close + 1 <= n) stack.add(new P(current.open, current.close+1));
            }
            return answer;
        }
    }
}
