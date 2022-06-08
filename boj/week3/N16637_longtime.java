package boj.week3;

import java.util.Scanner;

// 괄호 추가하기
public class N16637_longtime {
    static int res = Integer.MIN_VALUE;
    static int[] nums;
    static char[] ops;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String exp = sc.next();
        // 괄호의 최대 개수 => 숫자 / 2
        int numCnt = N/2 +1;
        nums = new int[numCnt]; // 3
        ops = new char[N - numCnt]; // 2
        boolean[] br = new boolean[numCnt - 1]; // 괄호 위치 (맨 뒤 숫자를 제외한 숫자 앞에 올 수 있음.) // 2
        int nidx = 0, oidx = 0;
        for (int i = 0; i < N; i++) {
            if(isNum(exp.charAt(i))) nums[nidx++] = exp.charAt(i) - '0';
            else ops[oidx++] = exp.charAt(i);
        }

        // br이 될 수 있는 모든 경우의 수 => solve 최대 값.
        // 괄호 개수 0 ~ numCnt/2
        // 괄호위치 앞이 true면 뒤에는 true가 될 수 없음.
        int depth = 0;
        while(depth <= (numCnt/2)){
            comb(br, 0, depth);
            depth++;
        }
        System.out.print(res);
    }

    static boolean isNum(char n){
        if(n >= '0' && n <= '9') return true;
        return false;
    }

    /**
     * ( 8 * 3 ) + 5
     * nums[] => 8, 3, 5
     * ops[]  => *, +
     * br[]   => true, false;
     *
     * 24 + 0 + 5
     * nums[] => 24, 0, 5
     * ops[] => +, +
     * br[] => false, false;
     */

    static int solve(int[] nums, char[] ops, boolean[] br) {
        for (int i = 0; i < br.length; i++) {
            if(br[i]){
                nums[i] = calculate(nums[i], nums[i + 1], ops[i]);
                nums[i+1] = 0;
                ops[i] = '+';
            }
        }

        for (int i = 0; i < ops.length; i++) {
            nums[i + 1] = calculate(nums[i], nums[i + 1], ops[i]);
        }
        return nums[nums.length - 1];
    }

    static int calculate(int A, int B, char op) {
        if(op == '+') return A+B;
        if(op == '-') return A-B;
        return A*B;
    }

    static void comb(boolean[] visited, int start, int r) {
        if (r == 0) {
            int[] newNums = nums.clone();
            char[] newOps = ops.clone();
            res = Math.max(res, solve(newNums, newOps, visited));
        }else{
            for (int i = start; i < visited.length; i++) {
                if(i!= 0 && visited[i-1]) continue;
                visited[i] = true;
                comb(visited, i+1, r - 1);
                visited[i] = false;
            }
        }
    }
}
