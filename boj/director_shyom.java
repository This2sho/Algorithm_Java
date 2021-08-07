package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

1 : 666 -> 2 : 1666 -> 3 : 2666 -> 4 : 3666 -> 5 : 4666 -> 6: 5666 -> 7: 6660 -> 8: 6661
*/

public class director_shyom {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();
        bw.write((int)n + "\n");
        bw.flush();

        bw.close();
    }
}
