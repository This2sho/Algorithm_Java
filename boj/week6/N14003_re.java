package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 5
public class N14003_re {
    static int[] arr, lis;
    static int curIdx = 0, lastIdx = 1, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        lis[0] = arr[0];
        solve();
        sb.append((curIdx + 1) + "\n");
        for (int i = 0; i <= curIdx; i++) sb.append(lis[i] + " ");
        System.out.print(sb);
    }

    static void solve() {
        while (lastIdx < N) {
            if (lis[curIdx] < arr[lastIdx]) {
                lis[++curIdx] = arr[lastIdx];
                System.out.println("if");
                printArr();
            }else{
                int idx = binarySearch(0, curIdx, arr[lastIdx]);
                lis[idx] = arr[lastIdx];
                System.out.println("else");
                printArr();
            }
            lastIdx++;
        }
    }

    static void printArr() {
        for (int li : lis) {
            System.out.print(li + " ");
        }
        System.out.println();
    }

    // {50, 10, 30, 40, 10, 20, 30, 40}

    /**
     * 숫자가 들어갈 위치를 이분탐색으로 찾는 함수
     */
    static int binarySearch(int left, int right, int target) {
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if(lis[mid] < target){ left = mid + 1;}
            else{
                idx = mid;
                right = mid-1;
            }

        }
        return idx;
    }
}
