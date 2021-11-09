package programmers.BruteForce;

import java.util.*;

class Solution2 {
    public int[] solution(int[] answers) {
        int[][] rule = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] point = {0, 0, 0};
        for(int i=0; i<answers.length; i++){
            if(answers[i] == rule[0][i%5]) point[0]++;
            if(answers[i] == rule[1][i%8]) point[1]++;
            if(answers[i] == rule[2][i%10]) point[2]++;
        }
        int max = Math.max(point[0], Math.max(point[1], point[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(max == point[0]) list.add(1);
        if(max == point[1]) list.add(2);
        if(max == point[2]) list.add(3);

        return list.stream().mapToInt(i-> i.intValue()).toArray();
    }
}

public class MockExam_good {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        int [] answer = s.solution(new int[] {1,2,3,4,5});
        for(int n : answer) System.out.println(n);
    }
}
