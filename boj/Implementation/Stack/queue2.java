package boj.Implementation.Stack;

import java.io.*;
import java.util.*;

public class queue2 {
    
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> q = new LinkedList<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int orderCount = Integer.parseInt(br.readLine());
        
        for(int i=0; i<orderCount; i++){
            String order = br.readLine();
            String temp = order.split(" ")[0];
            switch (temp){
                case "push":
                    int value = Integer.parseInt(order.split(" ")[1]);
                    q.add(value);
                    break;
                case "pop":
                    if(q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.poll()+ "\n");
                    break;
                case "size":
                    bw.write(q.size()+ "\n");
                    break;
                case "empty":
                    if(q.isEmpty()) bw.write(1+ "\n");
                    else bw.write(0+ "\n");
                    break;
                case "front":
                    if(q.isEmpty()) bw.write(-1+ "\n");
                    else bw.write(q.peek()+ "\n");
                    break;
                case "back":
                    if(q.isEmpty()) bw.write(-1+ "\n");
                    else bw.write(q.getLast()+ "\n");
                    break;
                default:
                    break;
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
}
