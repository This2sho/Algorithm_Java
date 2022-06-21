package boj.week4;

import java.util.Scanner;
import java.util.Stack;

// 게리맨더링
public class N17471 {
    static int N, res, visited;
    static int PEOPLESUM = 0;
    static Stack<Integer> stack = new Stack<>();
    static int[] people, link;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N + 1];
        link = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = sc.nextInt();
            PEOPLESUM += people[i];
        }
        res = PEOPLESUM;
        for (int i = 1; i <= N; i++) {
            int temp = sc.nextInt();
            for (int j = 0; j < temp; j++) {
                int node = sc.nextInt();
                link[i] |= (1 << node - 1);
            }
        }

        for (int i = 1; i <= (1 << N - 1); i++) {
            if (canGo(i, 0)) {
                int sum = 0;
                for (int j = 1; j < N; j++) {
                    if((i & (1 << j-1)) > 0) sum += people[j];
                }
                int a = PEOPLESUM - sum;
                int b = sum;
                int dif = Math.abs(a - b);
                res = Math.min(res, dif);
            }
        }
        if(res == PEOPLESUM) System.out.print(-1);
        else System.out.print(res);

    }

    /**
     * num은 선택 된 비트
     * sum은 선택 된 비트에서 갈 수 있는 노드를 다합친 비트
     */
    static boolean canGo(int num, int depth) {
        if(depth == 2) return true;
        int firstBit = num & -num;
        visited = 0;
        stack.add(firstBit);
        checkVisit(num);
        if((num & visited) == num) return canGo((1 << N) - 1-num, depth+1);
        return false;
    }

    static void checkVisit(int num) {
        while(!stack.empty()) {
            Integer pop = stack.pop();
            for (int i = 1; i <= N; i++) {
                int now = 1 << i - 1;
                if ((pop & now) > 0 && (num & now) > 0) {
                    if ((visited & now) > 0) continue;
                    visited |= now;
                    stack.add(link[(i)]);
                }
            }
        }
    }

    static void printBit(int num) {
        for (int i = N; i >= 1; i--) {
            if((num & (1<< i-1)) > 0){
                System.out.print(1 + " ");
            }else System.out.print(0 + " ");
        }
        System.out.println();
    }
}
