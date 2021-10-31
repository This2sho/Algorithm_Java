package boj.Implementation;

import java.util.*;

public class PrintN {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for(int i=1; i<=N; ++i){
            System.out.println(i);
        }
        s.close();
    }
}
