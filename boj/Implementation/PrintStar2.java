package boj.Implementation;

import java.util.*;

public class PrintStar2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=1; i<=N; ++i){
            if(i != N) System.out.print(String.format("%"+(N-i)+"s", ""));
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        s.close();
    }
}
