package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class n_m4 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        init_number(N);
        combination(temp, result, M);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

    static void combination(List<Integer> temp, List<List<Integer>> result, int m){
        if(temp.size() == m){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i : nums){
            if(temp.size() > 0 && temp.get(temp.size()-1) > i){
                continue;
            }
            temp.add(i);
            combination(temp, result, m);
            temp.remove(temp.size()-1);
        }
    }

}
