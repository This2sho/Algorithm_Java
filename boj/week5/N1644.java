package boj.week5;

import java.util.PriorityQueue;
import java.util.Scanner;

// 소수의 연속합
public class N1644 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 2; i < N; i++) {
            if(isPrime(i)){
                sum += i;
                pq.offer(i);
                if(sum > N){
                    while(sum > N && !pq.isEmpty()) sum -= pq.poll();
                }
                if(sum == N) res++;
                if(i >= N/2) break;
            }
        }
        if(isPrime(N)) res++;
        System.out.print(res);
    }

    static boolean isPrime(int n) {
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) if(n % i == 0) return false;
        return true;
    }
}
