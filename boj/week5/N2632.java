package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 피자판매
public class N2632 {
    static int wantSize;
    static int[] A, B;
    static int[][] aSum, bSum;
    static int m, n;
    static HashMap<Integer, Integer> aMap = new HashMap<>();
    static HashMap<Integer, Integer> bMap = new HashMap<>();
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wantSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        A = new int[m];
        B = new int[n];
        aSum = new int[m][m];
        bSum = new int[n][n];
        for(int i=0; i<m; i++) A[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) B[i] = Integer.parseInt(br.readLine());
        init();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : aMap.entrySet()) {
            System.out.println("integerIntegerEntry = " + integerIntegerEntry);
        }
//        solve();
//        System.out.print(res);
    }

    static void init() {
        for (int i=0; i<=m; i++) pick(i, A, aSum, aMap);
        for (int i=0; i<=n; i++) pick(i, B, bSum, bMap);
    }

    static void pick(int depth, int[] arr, int[][] pSum, HashMap<Integer, Integer> map) {
        if(depth == 0){
            map.put(0, 1);
            return;
        }
        if (depth == arr.length) {
            map.put(pSum[0][depth-1] + arr[depth-1], 1);
            return;
        }
        for(int i = 0; i<arr.length; i++){
            pSum[i][depth] = pSum[i][depth - 1] + arr[(i + (depth - 1)) % arr.length];
            map.put(pSum[i][depth], map.getOrDefault(pSum[i][depth], 0) + 1);
        }
    }

    static void solve() {
        for (int i = 0; i <= wantSize; i++) {
            int a = aMap.getOrDefault(i, 0);
            int b = bMap.getOrDefault(wantSize - i, 0);
            res += a*b;
        }
    }
}
