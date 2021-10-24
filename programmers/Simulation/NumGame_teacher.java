package programmers.Simulation;
import java.util.*;

public class NumGame_teacher {
    // 숫자가 큰 쪽이 승리(1점), 같으면 (0점)
    // A팀 순서 인지, B팀은 승점 제일 크게 갖도록 답을 내시오.
    // 패에 상관없이 제일 많이 이겨야함
    // 이때 A의 제일 높은 수는 B의 제일 높은수로 배치해야 이김
    // 하지만, A의 제일 높은수가 B의 제일 높은수로 못이기면 제일 낮은걸로 이겨야한다.
    // 배열의 길이는 100,000 이하
    // 정렬(내림차순)해서 LinkedList에 넣고
    // 최대값끼리 비교해서 B가 크면 양쪽 앞를 떼고
    // B가 작으면 A의 앞과 B의 뒤를 떼면 될듯.
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.solution(new int[] {5,1,3,7},new int[] {2,2,6,8}));
    }

}
class Solution2 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);

        int idx = B.length - 1;
        for(int i=A.length-1; i >=0; i--){
            if(B[idx] > A[i]){
                answer ++;
                idx--;
            }
        }
        return answer;
    }    
}