package boj;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
boj #15650

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    - 고른 수열은 오름차순이어야 한다.

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
*/
public class n_m2 {
    static int[] nums;

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        init_number(n);
        backtracking(temp, result, m);
        
        for(List<Integer> a : result){
            for(int b : a){
                bw.write(b+ " ");
            }
            bw.append("\n");
            bw.flush();
        }
        bw.close();

    }
    
    static void init_number(int n){
        nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = i+1;
        }
    }

    static void backtracking(List<Integer> temp, List<List<Integer>> result, int m){
        if(temp.size() == m){
            result.add(new ArrayList<>(temp));
        }
        for(int i : nums){
            if(temp.size() == 0){}
            else if(temp.contains(i) || temp.get(temp.size()-1) > i){
                continue;
            }
            temp.add(i);
            backtracking(temp, result, m);
            temp.remove(temp.size()-1);
        }
    }


}
