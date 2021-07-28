package boj;

/*
boj #10872
입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.
*/
import java.util.Scanner;

public class factorial {
    public static int fact(int n){
        if(n <= 1) return 1;
        else return n*fact(n-1);
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        System.out.print(fact(N));
    }
}
