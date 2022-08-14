package boj.week6;
import java.io.*;
import java.util.Arrays;
// 연속부분최대곱
public class N2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        for(int i=0; i<N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double max = Arrays.stream(arr).max().getAsDouble();
        for (int i = 0; i < N; i++) {
            double tmp = arr[i];
            for (int j = i + 1; j < N; j++) {
                tmp *= arr[j];
                max = Math.max(max, tmp);
            }
        }
        System.out.print(String.format("%.3f", max));
    }
}
