package programmers.Greedy;

public class station_install_teacher {
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.solution(11,new int[] {4, 11}, 1));
    }
}

// 효율성 문제!!
// class Solution2 {
//     public int solution(int n, int[] stations, int w) {
//         int answer = 0;
        
//         Queue<Integer> sq = new LinkedList<>();
//         for(int s : stations){
//             sq.offer(s);
//         }
        
//         int position = 1;
//         while(position <= n){
//             if(!sq.isEmpty() && sq.peek() - w <= position){
//                 position = sq.poll() + w + 1;
//             }else{
//                 position += 2*w +1;
//                 answer++;
//             }
//         }
        
//         return answer;
//     }
// }

/**
 * 효율성 테스트할 때 점수가 안나오면
 * 첫번째로 줄일 수 있는 loop문을 찾아야함.
 * 두번째로 적절한 데이터 구조 사용
 * 세번째로 object 타입을 primitive 타입으로 바꿔줘야함.(불필요한 오브젝트 제거)
 * 
 * 이 문제에서는 loop문에서 줄일게 없음으로 queue를 primitive타입인 int[]로 해결!
 */
class Solution2 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        
        int position = 1;
        while(position <= n){
            if(si < stations.length && stations[si] - w <= position){
                position = stations[si++] + w + 1;
            }else{
                position += 2*w +1;
                answer++;
            }
        }
        
        return answer;
    }
}