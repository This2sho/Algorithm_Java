package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
boj # 1436
입력
첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.

예제 입력 1 
2
예제 출력 1 
1666

3 자리수 일때,
 666 
=> n = 1
4 자리수 일때,
 666.0~9 (10개)
 1~9.666 (9개)
=>  n>=2, n<21
5 자리수 일때,
 a b c d e
 666. 0~9 0~9  (100개)
 1~9 .666. 0~9 (90개)
 1~9 0~9 .666 (90개)
 => n>=21, n<301

6 자리수 일때,
 a b c d e f
 6 6 6       (1000개)
   6 6 6     (900개)   
     6 6 6   (900개)
       6 6 6 (900개)
=> n>=301, n<4001
7 자리수 일때,
a b c d e f g
6 6 6 x x x x
x 6 6 6 x x x
x x 6 6 6 x x
x x x 6 6 6 x
x x x x 6 6 6
10000개 + 9000개 + 9000개 + 9000개 + 9000개

=> n>=4001, n<50001
*/ 

class Main {
    static ArrayList<Integer> s = new ArrayList<Integer>();
    static void init(){
        for(int i=666; i<10000000; ++i){
            String n = Integer.toString(i);
            if(n.contains("666")){
                s.add(i);
            }
        }
    }

    static int find_num(int n){
        return s.get(n-1);
    }
    
    // static int movie_title(int n){
    
    // }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        init();
        System.out.println(find_num(n));
        bw.flush();

        bw.close();
    }
}
