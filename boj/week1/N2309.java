package boj.week1;

import java.util.*;


// 일곱 난쟁이
public class N2309 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = new int[10];
        int sum = 0;
        int[] fsum = new int[10];

        int first = 0;
        int second = 0;

        for (int i = 1; i < 10; i++) {
            arr[i] = s.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        for (int i = 1; i < 10; i++) {
            fsum[i] = sum - arr[i] - 100;
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if(i==j) continue;
                if(fsum[i] == arr[j]){
                    first = i;
                    second = j;
                }
            }
        }


        for (int i = 1; i < 10; i++) {
            if(i != first && i != second) System.out.println(arr[i]);
        }
    }
}
