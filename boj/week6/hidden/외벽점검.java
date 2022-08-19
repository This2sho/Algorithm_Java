package boj.week6.hidden;

public class 외벽점검 {
    public static void main(String[] args) {
        System.out.println(solution(12, new int[] {1, 5, 6, 10}, new int[] {1, 2, 3, 4}));
        System.out.println(solution(12, new int[] {1, 3, 4, 9, 10}, new int[] {3, 5, 7}));
    }

    static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        return answer;
    }

    static int getDistance(int n, boolean direction, int start, int end) {
        // 시계
        if(direction){
            if(start < end) return end - start;
            return (n - start) + end;
        }
        if(start < end) return start + (n - end);
        return start - end;
    }
}
