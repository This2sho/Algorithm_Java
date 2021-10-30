package programmers.Dynamic;

import java.util.stream.*;

public class IntTriangle {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            /*
                cache 사용 (이전에 지나온 수의 합)
                Left와 Right 두 갈래로 갈 수 있다면 큰값을 선택.
                마지막 배열에서 제일 큰 값 선택.
            */
            final int triHeight = triangle.length;
            int[][] cache = new int[triHeight][];
            for(int i=0; i<triHeight; i++){
                cache[i] = new int[triangle[i].length];
            }
            cache[0][0] = triangle[0][0];
            for(int i=0; i<triHeight-1; i++){
                for(int j=0; j<triangle[i].length; ++j){
                    // 왼쪽 자식
                    if(cache[i+1][j] != 0){
                        int temp = cache[i][j] + triangle[i+1][j];
                        cache[i+1][j] = Math.max(cache[i+1][j], temp);
                    }else{
                        cache[i+1][j] = cache[i][j] + triangle[i+1][j]; 
                    }
                    // 오른쪽 자식
                    cache[i+1][j+1] = cache[i][j] + triangle[i+1][j+1];
                }
            }
            answer = IntStream.of(cache[triHeight-1]).max().orElse(0);
            return answer;
        }
    }
}
