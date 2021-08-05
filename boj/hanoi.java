package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/*
boj # 11729

입력
첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.

출력
첫째 줄에 옮긴 횟수 K를 출력한다.
두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.

처음 문제 풀 때 StringBuffer를 사용하지않고 String으로 더해서 값을 구했더니
String(tmp)에 값을 더해줄때마다 새로 생성함으로 각 String의 주소값이 stack에 쌓이고 class들은 garbage collector가 호출되기 전까지
heap에 지속적으로 쌓이게 되는걸 몰랐다.. 메모리 측면에서도 치명적이고 속도 또한 시간제한에 걸렸다.

String대신 StringBuffer 클래스를 사용함으로서 tmp의 값이 변화해도 같은 메모리에 append하는 방식이라 클래스가 생성됨으로서 method들과 variable들이 생성되는 시간이 추가적으로 들지않아
시간제한에 안걸린것 같다.
+1) StringBuffer와 StringBuilder의 차이는 둘 다 변경가능한 문자열이지만 StringBuilder는 synchronization이 적용되지 않고,
    StringBuffer는 적용되어 multiple thread에서 안전한 클래스라고 한다.

+2) 자바 알고리즘에서 입/출력에서 시간 단축하는 방법

    입력 : Scanner 대신 BufferedReader를 사용한다.
    예시 : BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    출력 : System.out.print 대신 BufferedWriter를 사용한다.
    예시 : static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
*/
public class hanoi {
    static StringBuffer tmp = new StringBuffer();
    static int sum = 0;

    // public static StringBuilder sb = new StringBuilder();
    

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // while(N <= 0){
        //     System.out.println("0이상 넣어라.");
        //     N = scanner.nextInt();
        // }
        do_hanoi(N, 1, 2, 3);
        bw.write((int) sum + "\n");
        bw.append(tmp);
    }

    public static void do_hanoi(int n, int src, int mid, int des){
        if(n == 1){
            sum++;
            tmp.append(src + " " + des + "\n");
        }
        else {
            do_hanoi(n-1, src, des, mid);
            do_hanoi(1, src, mid, des);
            do_hanoi(n-1, mid, src, des);
        }
    }
}
