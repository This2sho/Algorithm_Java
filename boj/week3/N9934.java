package boj.week3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 완전 이진 트리
public class N9934 {
    static LinkedList<Integer>[] list;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        list = new LinkedList[K];
        for (int i = 0; i < K; i++) {
            list[i] = new LinkedList<>();
        }
        int[] memo = new int[(int)Math.pow(2, K) - 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = sc.nextInt();
        }
        init(memo, 0);
        for (LinkedList<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            if(--K != 0)System.out.println();
        }
    }

    static void init(int[] arr, int depth) {
        if(arr.length == 1){
            list[depth].add(arr[0]);
            return;
        }
        int midIdx = arr.length / 2;
        list[depth].add(arr[midIdx]);
        int[] left = Arrays.copyOfRange(arr, 0, midIdx);
        int[] right = Arrays.copyOfRange(arr, midIdx+1, arr.length);
        init(left, depth+1);
        init(right, depth+1);
    }
}
