package boj.Implementation;

import java.util.*;

public class gugudan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i=1; i<10; i++){
            System.out.println(N + " * " + i + " = " + N*i);
        }
        scanner.close();
    }
}
