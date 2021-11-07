package boj.Implementation;

import java.util.*;

public class zero {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int K = s.nextInt();
        for(int i=0; i<K; i++){
            int v = s.nextInt();
            if(!stack.isEmpty() && v == 0) stack.pop();
            else stack.add(v); 
        }
        s.close();
        int sum = 0;
        for(int n : stack) sum+= n;
        System.out.print(sum);
    }
}
