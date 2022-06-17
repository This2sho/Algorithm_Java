package boj.week4;
import java.util.Scanner;
// 다이어트
public class N19942 {
    static int N;
    static int[] m = new int[4];
    static int[] bits;
    static int[][] map;
    static int resCost = Integer.MAX_VALUE, resNum=-1;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            m[i] = sc.nextInt();
        }
        bits = new int[N];
        map = new int[N][5];
        // 4에는 가격
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        initBits(N);

        /**
         * N 가지 식재료 뽑기 => N 비트로 표현가능
         * 6 => 6 bit ( 00 0000 ~ 11 1111) => (0 ~ 127)
         * 1이면 선택 , 0이면 선택x
         * 1, 2, 4, 8, 16, 32
         */

        for (int n = 0; n < 1 << N; n++) {
            int cost = 0;
            int[] temp = new int[4];
            for (int i = 0; i < N; i++) {
                if ((n & bits[i]) > 0) {
                    cost += map[i][4];
                    for (int j = 0; j < 4; j++) {
                        temp[j] += map[i][j];
                    }
                }
                if (isValid(cost, temp)) {
                    if (resCost == cost) {
                        if(fastNum(resNum, n)) resNum = n;
                        continue;
                    }
                    resCost = cost;
                    resNum = n;
                }
            }
        }
        if(resNum == -1) System.out.print(-1);
        else printRes(resNum);
    }

    static void initBits(int n) {
        for (int i = 0; i < n; i++) {
            bits[i] = 1 << i;
        }
    }

    static boolean isValid(int cost, int[] temp) {
        if(cost <= resCost){
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if(m[i] > temp[i]) return false;
                sum += temp[i];
            }
            if(sum <= 0) return false;
            return true;
        }
        return false;
    }

    static boolean fastNum(int a, int b) {
        StringBuffer asb = new StringBuffer();
        StringBuffer bsb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            if((a & bits[i]) > 0) asb.append(i+1 +" ");
            if((b & bits[i]) > 0) bsb.append(i+1 +" ");
        }
        if(asb.toString().compareTo(bsb.toString()) < 0) return false;
        return true;
    }

    static void printRes(int n) {
        System.out.println(resCost);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            if((n & bits[i]) > 0) sb.append(i+1 +" ");
        }
        System.out.print(sb.toString().trim());
    }
}
