package boj.week4;
import java.io.*;
import java.util.StringTokenizer;
// 가르침
public class N1062 {
    static int N, K;
    static int[] words;
    static int visited = 0, need =0, res=0;
    static int[] starts = {'a' - 'a', 'c' - 'a', 'i' - 'a', 'n' - 'a', 't' - 'a'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] temp = s.substring(4, s.length()-4).toCharArray();
            for (char c : temp) {
                words[i] |= 1 << c - 'a';
            }
        }
        for (int start : starts) {
            visited |= 1 << start;
            K--;
        }
        //필요한 글자들
        for (int w : words) {
            int n = w - (w & visited);
            need |= n;
        }
        int needCnt = 0;
        for(int i = 1; i < 1 << 26; i *= 2){
            if((need & i) > 0) needCnt++;
        }
        if(needCnt < K) K = needCnt;

        solve(1, visited, 0);
        System.out.print(res);
    }

    static void solve(int start, int learn, int depth) {
        if (depth == K) {
            res = Math.max(check(learn), res);
            return;
        }
        for (int i = start; i < 1 << 26; i *= 2) {
            if((need & i) > 0) {
                solve(i * 2, learn | i, depth+1);
            }
        }
    }

    static int check(int learn) {
        int cnt = 0;
        for (int s : words) {
            if((learn & s) == s) cnt++;
        }
        return cnt;
    }
}

// wx, y , z