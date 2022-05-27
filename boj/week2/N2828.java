package boj.week2;

import java.util.Scanner;

// 사과 담기 게임
public class N2828 {
    static boolean[] budgetState;
    static int[] pos = new int[2];
    static int M, answer = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt(); // 바구니 크기
        int J = sc.nextInt();

        budgetState = new boolean[N+1];
        for(int i=1; i<=M; i++) budgetState[i] = true;
        pos[0] = 1; pos[1] = M;

        for (int i = 0; i < J; i++) {
            int location = sc.nextInt();
            if(!isTouched(location)){
                if(location < pos[0]) shiftBudget(location - pos[0]);
                else shiftBudget(location - pos[1]);
            }
        }
        System.out.print(answer);
    }

    static void shiftBudget(int move){
        int nBegin = pos[0] + move;
        int nEnd = pos[1] + move;

        for(int i=pos[0]; i<=pos[1]; i++) budgetState[i] = false;
        for(int i=nBegin; i<=nEnd; i++) budgetState[i] = true;
        pos[0] = nBegin;
        pos[1] = nEnd;
        answer+= Math.abs(move);
    }

    static boolean isTouched(int location) {
        if(budgetState[location]) return true;
        return false;
    }
}
