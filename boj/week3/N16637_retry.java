package boj.week3;

import java.util.LinkedList;
import java.util.Scanner;

// 괄호 추가하기
public class N16637_retry {
    static LinkedList<Character> ops = new LinkedList<>();
    static LinkedList<Integer> nums = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String exp = sc.next();
        for (int i = 0; i < N; i++) {
            if(i % 2 == 1) ops.add(exp.charAt(i));
            else nums.add(Character.getNumericValue(exp.charAt(i)));
        }
        solve(0, nums.get(0));
        System.out.print(answer);
    }

    static void solve(int opIdx, int sum) {
        if (opIdx >= ops.size()) {
            answer = Math.max(sum, answer);
            return;
        }
        // 괄호 없을 때
        int res = calculate(sum, nums.get(opIdx + 1), ops.get(opIdx));
        solve(opIdx + 1, res);

        //오른쪽에 괄호 있을 때
        if (opIdx + 1 < ops.size()) {
            int res2 = calculate(nums.get(opIdx + 1), nums.get(opIdx + 2), ops.get(opIdx + 1));
            solve(opIdx+2, calculate(sum, res2, ops.get(opIdx)));
        }
    }

    static int calculate(int A, int B, char op) {
        if(op == '+') return A + B;
        if(op == '-') return A - B;
        else return A * B;
    }
}
