package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

// 게임
public class N1072 {
    static int n, win, percent;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        win = Integer.parseInt(st.nextToken());
        percent = getWinPercent(n, win);
        binarySearch();
        System.out.print(result);
    }

    static void binarySearch() {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            int N = n + mid;
            int W = win + mid;
            if (getWinPercent(N, W) > percent) {
                result = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
    }

    static int getWinPercent(int n, int w) {
        BigDecimal N = new BigDecimal((n + ""));
        BigDecimal W = new BigDecimal((w + ""));
        return W.divide(N, 2, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100)).intValue();
    }
}
