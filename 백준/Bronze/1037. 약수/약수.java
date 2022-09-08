import java.io.*;
import java.util.*;
// 약수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        if (N % 2 == 0) System.out.print((Arrays.stream(arr).max().getAsInt() * Arrays.stream(arr).min().getAsInt()));
        else{
            Arrays.sort(arr);
            System.out.print(arr[N/2] * arr[N/2]);
        }
    }
}