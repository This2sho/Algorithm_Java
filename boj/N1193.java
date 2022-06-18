package boj;

import java.util.Scanner;

public class N1193 {
    static int[] cache = new int[10001];
    static int row, col;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        init();
        findRowCol(N);
        int a, b;
        if(row % 2 == 0){
            a = 1;
            b = row;
        }else{
            a = row;
            b = 1;
        }
        for (int i = 0; i < col; i++) {
            if(row % 2 == 0){
                a++;
                b--;
            }else{
                a--;
                b++;
            }
        }
        System.out.print(a+"/"+b);

    }
    static void init() {
        cache[1] = 1;
        for (int i = 2; i <= 10000; i++) {
            cache[i] = cache[i-1] + i-1;
        }
    }

    static void findRowCol(int n) {
        for (int i = 1; i <= 10000; i++) {
            if (n >= cache[i - 1] && n < cache[i]) {
                row = i-1;
                col = n - cache[i - 1];
                return;
            }
        }
    }
}
