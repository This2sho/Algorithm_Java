package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// List of Unique Numbers
public class N13144_re {
    static int N, res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        long ans = 0;

        HashSet<Integer> visited = new HashSet<>();   //숫자 체크할 해쉬셋
        int left = 0;
        int right = 0;

        while(true) {
            if(right==N) {
                if(left==N) break;

                else {
                    ans += (right-left);
                    left++;
                }
            }

            else if(!visited.contains(arr[right])) {    //포함안된 숫자면 포인터 늘림
                visited.add(arr[right]);
                right++;
            }

            else {
                ans += (right-left);          //이미 포함된 숫자면 다 더해주고 시작 idx 늘림
                visited.remove(arr[left]);
                left++;
            }
        }

        System.out.print(ans);
    }
}
