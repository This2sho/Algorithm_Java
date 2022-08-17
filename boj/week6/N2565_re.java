package boj.week6;
import java.io.*;
import java.util.*;
// 전깃줄
public class N2565_re {
    static Wire[] wires;
    static int[] arr, idxArr, lis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        wires = new Wire[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(a, b);
        }
        arr = Arrays.stream(wires).sorted().mapToInt(o -> o.b).toArray();
        idxArr = new int[N];
        lis = new int[N];
        idxArr[0] = 0;
        lis[0] = arr[0];
        int curIdx = 0;
        for (int i = 1; i < N; i++) {
            if (lis[curIdx] < arr[i]) {
                idxArr[i] = curIdx + 1;
                lis[++curIdx] = arr[i];
            }else{
                int idx = binarySearch(0, curIdx, arr[i]);
                idxArr[i] = idx;
                lis[idx] = arr[i];
            }
        }
        System.out.print((N - (Arrays.stream(idxArr).max().getAsInt()+1)));
    }

    static class Wire implements Comparable<Wire>{
        int a;
        int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire o) {
            return this.a - o.a;
        }
    }

    static int binarySearch(int left, int right, int target) {
        int idx = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            }else{
                idx = mid;
                right = mid - 1;
            }
        }
        return idx;
    }
}
