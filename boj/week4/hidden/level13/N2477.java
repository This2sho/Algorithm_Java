package boj.week4.hidden.level13;
import java.io.*;
import java.util.StringTokenizer;

// 참외밭
public class N2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[6];
        int maxWidthIdx = 0, maxWidth = 0, maxHeightIdx = 0, maxHeight = 0;
        int minWidth, minHeight;

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());
            if(d==1 || d==2){
                maxWidth = Math.max(maxWidth, arr[i]);
                if(arr[i] == maxWidth) maxWidthIdx = i;
            }
            else{
                maxHeight = Math.max(maxHeight, arr[i]);
                if(arr[i] == maxHeight) maxHeightIdx = i;
            }
        }
        minHeight = getMinLength(maxWidthIdx, arr);
        minWidth = getMinLength(maxHeightIdx, arr);
        System.out.print(K * (maxHeight * maxWidth - minHeight * minWidth));
    }

    static int getMinLength(int idx, int arr[]) {
        int right = idx-1;
        if(right == -1) right = 5;
        int left = idx+1;
        if(left == 6) left = 0;
        return Math.abs(arr[right] - arr[left]);
    }
}
