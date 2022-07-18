package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 톱니바퀴 (2)
public class N15662 {
    static int T;
    static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        state = new int[T];
        // 4랑 64의 비트가 같은지 확인
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if(s.charAt(j) == '1') state[i] |= 1 << 7-j;
            }
        }
        int K = Integer.parseInt(br.readLine());
        int[][] rotateInfo = new int[K][2];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotateInfo[i][0] = Integer.parseInt(st.nextToken())-1;
            rotateInfo[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int k = 0; k < K; k++) {
            int idx = rotateInfo[k][0];
            boolean dir = rotateInfo[k][1] == 1 ? true : false;
            System.out.println(idx+1 + "번째 톱니바퀴 " + dir + " 회전");
            int[] next = state.clone();
            rotate(next, idx, dir);
            // 1 => S | 0 => N
            for (int i = idx+1; i <= T - 1; i++) {
                System.out.println(i-1 + " = " + ((state[i-1] & 4) > 0));
                System.out.println(i + " = " + ((state[i] & 64) > 0));
                if ((state[i-1] & 4) > 0 != (state[i] & 64) > 0) {
                    System.out.println("right i = " + i);
                    // 반대로 돌려야함
                    dir = !dir;
                    rotate(next, i, dir);
                }else break;
            }
            dir = rotateInfo[k][1] == 1 ? true : false;
            for (int i = idx - 1; i >= 0; i--) {
                if ((state[i] & 4) > 0 != (state[i + 1] & 64) > 0) {
                    // 반대로 돌려야함
                    System.out.println("left i = " + i);
                    dir = !dir;
                    rotate(next, i, dir);
                }else break;
            }
            state = next.clone();
            print();
            System.out.println();
        }
        int res = 0;
        for(int i=0; i<T; i++) if((state[i] & 1) > 0) res++;
        System.out.print(res);
    }

    static void print() {
        for (int i : state) {
            String temp = "";
            for(int j=7; j>=0; j--){
                if((i & (1 << j)) > 0) temp += "S";
                else temp += "N";
            }
            System.out.println(temp);
        }
    }

    static void rotate(int[] state, int idx, boolean dir) {
        boolean last = false;
        if (dir) {
            if((state[idx] & 1) > 0) last=true;
            state[idx] = state[idx] >> 1;
            if(last) state[idx] |= (1<<7);
            return;
        }
        if((state[idx] & (1<<7)) > 0) last=true;
        state[idx] = state[idx] << 1;
        if(last) state[idx] |= 1;
    }

}
