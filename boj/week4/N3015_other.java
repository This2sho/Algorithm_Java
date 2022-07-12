package boj.week4;
import java.util.*;
//오아시스 재결합
public class N3015_other {
    static class People{
        int height, cnt;
        public People(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<People> stack = new Stack<>();
        long sum = 0;
        while (N-- > 0) {
            int cur = sc.nextInt();
            while (!stack.isEmpty() && stack.peek().height < cur) {
                sum += stack.pop().cnt;
            }
            int tmp = 0;
            if (!stack.isEmpty() && stack.peek().height == cur) {
                tmp = stack.pop().cnt;
            }
            sum+= tmp;
            if(!stack.isEmpty()) sum++;
            stack.push(new People(cur, tmp + 1));
        }
        System.out.print(sum);
    }
}