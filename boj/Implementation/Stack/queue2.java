package boj.Implementation.Stack;

import java.util.*;

public class queue2 {
    
    public static void main(String[] args){
        Queue<Integer> q = new LinkedList<>();
    
        Scanner scanner = new Scanner(System.in);
    
        int orderCount = scanner.nextInt();
        
        for(int i=0; i<orderCount; i++){
            String temp = scanner.next();
            int value;
            switch (temp){
                case "push":
                    value = scanner.nextInt();
                    q.add(value);

                case "pop":
                    if(q.isEmpty()) System.out.println(0);
                    else System.out.println(q.poll());

                case "size":
                    System.out.println(q.size());

                case "empty":
                    if(q.isEmpty()) System.out.println(1);
                    else System.out.println(0);

                case "front":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.peek());

                case "back":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.offer(q.size()-1));

                default:
                    break;
            }
            
        }
    }
    
}
