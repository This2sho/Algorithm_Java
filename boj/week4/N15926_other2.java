package boj.week4;

import java.util.*;

public class N15926_other2 {

    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res = 0 , cnt = 0;
        int d[] = new int[200001];
        int N = sc.nextInt();
        String S = sc.next();
        for (int i = 0; i < N; i++) {
            if(S.charAt(i) == '(') stack.push(i);
            else if (!stack.isEmpty()) {
                d[i] = d[stack.peek()] = 1;
                stack.pop();
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println("d[" + i +"] = " + d[i]);
            if (d[i] > 0) {
                cnt++;
                res = Math.max(res, cnt);
            }else cnt = 0;
        }
        System.out.print(res);
    }
}