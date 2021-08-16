package boj;

import java.util.Scanner;

/*
boj #15649

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1

예제 출력 1 
1
2
3

3 2

1 2
1 3
2 1
2 3
3 1
3 2

3 3
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

for i = 1 ; i <= N; ++i;

*/

public class n_m {
    static int[] nums;
    static int[] results;
    static void init_nums(int N, int M){
        nums = new int[N];
        results = new int[M];
        for(int i=0; i<N; ++i){
            nums[i] = i+1;
        }
    }
    static void permutation(int n, int m, int[] can){
        
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        init_nums(n, m);

        System.out.printf("%d, %d\n", n, m);
        System.out.println(nums.length);
        System.out.println(results[1]);
    }
    
}
