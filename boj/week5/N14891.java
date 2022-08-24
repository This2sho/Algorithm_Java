package boj.week5;
import java.io.*;
import java.util.StringTokenizer;
// 톱니바퀴
public class N14891 {
    static int T = 4;
    static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        state = new int[T];
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
            int[] next = state.clone();
            rotate(next, idx, dir);
            for (int i = idx+1; i <= T - 1; i++) {
                if ((state[i-1] & 32) > 0 != (state[i] & 2) > 0 ) {
                    dir = !dir;
                    rotate(next, i, dir);
                }else break;
            }
            dir = rotateInfo[k][1] == 1 ? true : false;
            for (int i = idx - 1; i >= 0; i--) {
                if ((state[i] & 32) > 0 != (state[i + 1] & 2) > 0) {
                    dir = !dir;
                    rotate(next, i, dir);
                }else break;
            }
            state = next.clone();
        }
        int res = 0;
        for(int i=0; i<T; i++) if((state[i] & 128) > 0) res += 1<<i;
        System.out.print(res);
    }

    static void rotate(int[] temp, int idx, boolean dir) {
        boolean last = false;
        if (dir) {
            if((temp[idx] & 1) > 0) last=true;
            temp[idx] = temp[idx] >> 1;
            if(last) temp[idx] |= (1<<7);
            return;
        }
        if((temp[idx] & (1<<7)) > 0) last=true;
        temp[idx] = temp[idx] << 1;
        if(last) temp[idx] |= 1;
    }
}