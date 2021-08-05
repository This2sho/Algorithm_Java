package boj;

import java.util.HashMap;
import java.util.Scanner;

/*
boj # 11729

입력
첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 옮긴 횟수 K를 출력한다.
두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.

1개일 때 
<1> -> <3>으로

2개일 때 1개를 2로 옮기고 1
<1> -> <2>

<1> -> <3>

<2> -> <3>

3개일 때 (위에 2개를 2로 옮기는 작업 후 무거운거 3으로 )
<1> -> <3>
<1> -> <2>
<3> -> <2>

<1> -> <3>

<2> -> <1>
<2> -> <3>
<1> -> <3>

4개일 때 (위에 3개를 2로 옮기는것 과 같은 작업후 무거운거 3으로 옮기고 2에 있는걸 3으로 옮기는 작업과 같음)
<1> -> <2>
<1> -> <3>
<2>
*/
public class hanoi {
    static String tmp = "";
    static int cnt = 0;

    static class res_hanoi{
        private String move = "";
        private int sum = 0;

        public res_hanoi(String move, int sum){
            this.move = move;
            this.sum  = sum;
        }
    }

    static HashMap<Integer, res_hanoi> cache = new HashMap<Integer, res_hanoi>();


    public static int else_num(int a, int b){
        switch(a+b){
            case 3 :
                return 3;
            case 4 :
                return 2;
            case 5 :
                return 1;
            default :
                return -1;            
        }
    }
    public static void do_hanoi(int n, int src, int des){
        int key = n*100 + src*10 + des;
        // key 있을 때
        if(cache.containsKey(key)){
            cnt += cache.get(key).sum;
            tmp += cache.get(key).move;
        }else{
            if(n == 1){
                cnt++;
                tmp += src + " " + des + "\n";
            }
            else {
                do_hanoi(n-1, src, else_num(src, des));
                do_hanoi(1, src, des);
                do_hanoi(n-1, else_num(src, des), des);
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // while(N <= 0){
        //     System.out.println("0이상 넣어라.");
        //     N = scanner.nextInt();
        // }
        do_hanoi(N, 1, 3);
        System.out.println(cnt);
        System.out.print(tmp);
    }
}
