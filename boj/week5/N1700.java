package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 멀티탭 스케줄링
public class N1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int res = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) arr[i] = Integer.parseInt(st.nextToken());

        boolean[] use = new boolean[104];
        int put = 0;
        for (int i = 0; i < K; i++) {
            int now = arr[i];
            if(use[now]) continue;
            if(put < N) {
                use[now] = true;
                put++;
            }
            else{
                LinkedList<Integer> check = new LinkedList<>();
                for (int j = i + 1; j < K; j++) { // 지금 쓰고 있고 뒤에도 쓸 예정인 것들 추가
                    if(use[arr[j]] && !check.contains(arr[j])) check.add(arr[j]);
                }
                if (check.size() == N) {
                    use[check.get(N-1)] = false;
                }else{
                    for (int j = 0; j < K; j++) {
                        if(use[j] && !check.contains(j)){
                            use[j] = false;
                            break;
                        }
                    }
                }
                use[now] = true;
                res++;
            }
        }
        System.out.print(res);
    }
}
