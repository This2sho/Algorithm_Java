package boj.week6;
import java.io.*;
import java.util.*;
// 가장 긴 증가하는 부분 수열 4
public class N14002 {
    static int N, curIdx;
    static int[] arr, lis, idxArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N];
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        curIdx = idxArr[0] = 0;
        lis[0] = arr[0];
        solve();
        print();
    }

    static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        int length = Arrays.stream(idxArr).max().getAsInt();
        sb.append((length+1) + "\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0 && length >= 0; i--) {
            if (idxArr[i] == length) {
                stack.add(arr[i]);
                length--;
            }
        }
        while (!stack.empty()) sb.append(stack.pop() + " ");
        System.out.print(sb);
    }

    static void solve() {
        for (int i = 1; i < N; i++) {
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

    static int binarySearch(int left, int right, int target) {
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) left = mid + 1;
            else {
                idx = mid;
                right = mid - 1;
            }
        }
        return idx;
    }
}