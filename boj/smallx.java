package boj;
// boj 10871번 문제.
import java.util.Scanner;

public class smallx {
    public static void main(String[] args){
        int N, X;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        X = scanner.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; ++i){
            arr[i] = scanner.nextInt();
        }

        for(int i=0; i<N; ++i){
            if(arr[i] < X){
                System.out.printf("%d ",arr[i]);
            }
        }
    }
}
