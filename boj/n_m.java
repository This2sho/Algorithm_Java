package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
    public static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    static void init_nums(int N){
        nums = new int[N];
        for(int i=0; i<N; ++i){
            nums[i] = i+1;
        }
    }
    static void  permutation(List<Integer> temp, int m){
        if(temp.size() == m){
            result.add(new ArrayList<>(temp));
        }else{
            for(int i=0; i< nums.length; ++i){
                if(temp.contains(nums[i])){
                    continue;
                }
                temp.add(nums[i]);
                permutation(temp, m);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        init_nums(n);
        permutation(temp, m);
        for(List<Integer> a : result){
            for(int b : a){
                bw.write(b + " ");
            }
            bw.append("\n");
            bw.flush();
        }
        bw.close();
    }
    
}
