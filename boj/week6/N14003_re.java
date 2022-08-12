package boj.week6;
import java.io.*;
import java.util.*;
// 가장 긴 증가하는 부분 수열 5
public class N14003_re {
    static int[] arr, lis, idxArr;
    static int curIdx = 0, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        lis[0] = arr[0];
        idxArr[0] = 0;
        solve();
        int idx = Arrays.stream(idxArr).max().getAsInt();
        sb.append((idx+1) + "\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0 && idx >= 0; i--) {
            if (idxArr[i] == idx) {
                stack.add(arr[i]);
                idx--;
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop() + " ");
        System.out.print(sb);
    }

    static void solve() {
        for(int i=1; i<N; i++){
            if (lis[curIdx] < arr[i]) {
                idxArr[i] = curIdx+1;
                lis[++curIdx] = arr[i];
            }else{
                int idx = binarySearch(0, curIdx, arr[i]);
                idxArr[i] = idx;
                lis[idx] = arr[i];
            }
        }
    }

    static void printArr(int[] arr) {
        for (int li : arr) {
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

/**
 * 9
 * 3 1 4 6 2 2 0 3 6
 *
 * 0 0 1 2 1 1 0 2 3
 */