package boj.week4;
import java.util.*;
// AC
public class N5430 {
    final static char R = 'R';
    static Deque<Integer> deque;
    static int[] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            char[] ops = sc.next().toCharArray();
            n = sc.nextInt();
            String s = sc.next();
            deque = new LinkedList<>();
            init(s);
            boolean reverse = false;
            boolean isError = false;
            for (int i = 0; i < ops.length; i++) {
                if(ops[i] == R) reverse =! reverse;
                else{
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    if (reverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if(isError){ sb.append("error\n");}
            else print(reverse);


        }
        System.out.print(sb);
    }

    static void init(String s) {
        char[] substring = s.substring(1, s.length()-1).toCharArray();
        int temp = 0;
        for (int i = 0; i < substring.length; i++) {
            if(substring[i] != ','){
                temp *= 10;
                temp += Character.getNumericValue(substring[i]);
            }else{
                deque.add(temp);
                temp = 0;
            }
            if(i==substring.length-1) deque.add(temp);
        }
    }

    static void print(boolean isReverse) {
        sb.append('[');
        if(isReverse){
            Collections.reverse((List) deque);
        }
        while(!deque.isEmpty()){
            if(deque.size()==1) sb.append(deque.pop());
            else sb.append(deque.pop() + ",");
        }
        sb.append(']' + "\n");
    }
}
