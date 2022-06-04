package boj.week2;

import java.util.Scanner;
import java.util.Stack;

// 오큰수
public class N17298 {
    static int[] A = new int[1000001];
    static int[] answer = new int[1000001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Pos> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if(i==0) stack.push(new Pos(i, A[i]));
            else {
                while(!stack.isEmpty()){
                    Pos top = stack.peek();
                    if(top.value < A[i]){
                        answer[top.idx] = A[i];
                        stack.pop();
                    }else break;
                }
                stack.push(new Pos(i, A[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            if(answer[i] != 0) sb.append(answer[i] + " ");
            else sb.append("-1 ");
        }
        System.out.print(sb.toString().trim());
    }

    static class Pos{
        int idx;
        int value;

        Pos(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
