package boj;

import java.util.LinkedList;
import java.util.Scanner;

class card2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        LinkedList<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        
        while(q.size() != 1){
            q.poll();
            int top = q.poll();
            q.add(top);
        }

        System.out.println(q.poll());
    }
}