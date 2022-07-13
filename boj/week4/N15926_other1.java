package boj.week4;
import java.util.*;

public class N15926_other1 {
    static int res = 0;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();
        stack.push(-1);
        for (int i = 0; i < N; i++) {
            if(S.charAt(i) == '(') stack.push(i);
            if(S.charAt(i) == ')'){
                stack.pop();
                if (!stack.isEmpty()) {
                    res = Math.max(res, i - stack.peek());
                }else{
                    stack.push(i);
                }
            }
        }
        System.out.print(res);
    }
}