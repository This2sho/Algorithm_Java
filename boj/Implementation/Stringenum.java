package boj.Implementation;

import java.util.Scanner;

public class Stringenum {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0; i<T; i++){
            int R = s.nextInt();
            String temp = s.next();
            for(int j=0; j<temp.length(); j++){
                for(int k=0; k<R; k++) System.out.print(temp.charAt(j));
            }
            System.out.println();
        }
    }
}
