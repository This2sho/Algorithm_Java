package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/*
boj #1003
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

출력
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

예제 입력 1 
3
0
1
3


fibo(n) = fibo(n-1) + fibo(n-2)

    0 1
0 = 1 0
1 = 0 1
2 = 1 1
3 = f(2) + f(1) = 1 1 + 0 1 = 1 2
4 = f(3) + f(2) = 1 2 + 1 1 = 2 3
5 = f(4) + f(3) = 2 3 + 1 2 = 3 5
6 = f(5) + f(4) = 3 5 + 2 3 = 5 8
cache 사용해야 할 듯.
*/
public class fibonacci {
    static void fib(int n){
        cache[0] = 0;
        cache[1] = 1;
        for(int i=2; i<n+1; ++i){
            cache[i] = cache[i-1] + cache[i-2];
        }
    }
    
    static int[] cache = new int[50];


    public static void main(String[] args) throws IOException{
        int N;
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = scanner.nextInt();
        fib(40);

        for(int i=0; i<N; ++i){
            int temp = scanner.nextInt();
            if(temp == 0) bw.append("1 0\n");
            else if(temp == 2) bw.append("1 1\n");
            else{
                bw.append(cache[temp-1] + " " + cache[temp] + "\n");
            }
        }
        bw.flush();
        scanner.close();
        bw.close();
    }
}
