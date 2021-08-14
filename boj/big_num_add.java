package boj;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/*
# boj 10757
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

출력
첫째 줄에 A+B를 출력한다.

예제 입력 1 
9223372036854775807 9223372036854775808
*/

public class big_num_add {
    public static Stack<Integer> result = new Stack<>();
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        scanner.close();
        string_add(A, B);
        // StringBuffer aaa = new StringBuffer();
        while(!result.empty()){
            System.out.print(result.pop());
        }
        System.out.println();
    }

    public static void string_add(String a, String b){
        // 더해서 나올 수 의 자릿수
        int big_num = 0;
        int small_num = 0;
        // 올라온 값
        int pre_tmp=0;
        int tmp = 0;
        if(a.length() > b.length()){
            big_num = a.length();
            small_num = b.length();
        }else{
            small_num = a.length();
            big_num = b.length();
        }
        int i=1;
        for(; i<=small_num; i++){
            int tmp_a = a.charAt(a.length()-i) - '0';
            int tmp_b = b.charAt(b.length()-i) - '0';
            tmp = tmp_a + tmp_b + pre_tmp;
            result.push(tmp%10);
            pre_tmp = tmp/10;
        }

        if(big_num - small_num > 0){
            for(; i<=big_num; i++){
                if(a.length() > b.length()){
                    int tmp_a = a.charAt(a.length()-i) - '0';
                    tmp = tmp_a + pre_tmp;
                    result.push(tmp%10);
                    pre_tmp = tmp/10;
                }
                else{
                    int tmp_b = b.charAt(b.length()-i) - '0';
                    tmp = tmp_b + pre_tmp;
                    result.push(tmp%10);
                    pre_tmp = tmp/10;
                }
            }
            if(pre_tmp > 0){
                result.push(pre_tmp);
            }
        }else{
            if(pre_tmp > 0){
                result.push(pre_tmp);
            }
        }
    }
}