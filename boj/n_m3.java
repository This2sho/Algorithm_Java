package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
boj #15651

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

*/

public class n_m3 {
    static int[] nums;
    static List<Integer> temp = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        int N;
        int M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init(N);
        combination(M);
        for(List<Integer> l : result){
            for(int i : l){
                bw.write(i + " ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void init(int n){
        nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = i+1;
        }
    }

    public static void combination(int M){
        if(temp.size() == M){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i : nums){
            temp.add(i);
            combination(M);
            temp.remove(temp.size()-1);
        }
    }
}
