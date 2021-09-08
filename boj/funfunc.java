package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/*
boj #9184
문제
재귀 호출만 생각하면 신이 난다! 아닌가요?
다음과 같은 재귀함수 w(a, b, c)가 있다.

if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
    1
if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
    w(20, 20, 20)
if a < b and b < c, then w(a, b, c) returns:
    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
otherwise it returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

위의 함수를 구현하는 것은 매우 쉽다. 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. 
(예를 들면, a=15, b=15, c=15)
a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.

입력
입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.

출력
입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.

a, b ,c 를 0에서 100까지로 생각.(입력받은 값 + 50)
->
if a <= 50 or b <= 50 or c <= 50, then w(a, b, c) returns:
    1
if a > 70 or b > 70 or c > 70, then w(a, b, c) returns:
    w(70, 70, 70)
if a < b and b < c, then w(a, b, c) returns:
    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
otherwise it returns:
    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

w(1, 1, 1) = w(0, 1, 1) + w(0, 0, 1) + w(0, 1, 0) - w(0, 0, 0)
w(1, 1, 2) = w(0, 1, 2) + w(0, 0, 2) + w(0, 1, 1) - w(0, 0, 1)
w(2, 1, 1)

1 ~ 20 까지 경우
1 1 1~20 -> 완성
1 1~20 1~20 -> 완성
1~20 1~20 1~20 -> 완성
2 3 4 -> 2 3 3, 2 2 3, 2 2 4

*/
class funfunc {
    static int[][][] cache = new int[101][101][101];
    public static void initfun(){
        for(int i=0; i<101; ++i){
            for(int j=0; j<101; ++j){
                for(int k=0; k<101; ++k){
                    if(i <= 50 || j <= 50 || k <= 50)
                        cache[i][j][k] = 1;
                }
            }
        }

        for(int i=51; i<71; ++i){
            for(int j=51; j<71; ++j){
                for(int k=51; k<71; ++k){
                    if(i < j && j < k){
                        cache[i][j][k] = cache[i][j][k-1] + cache[i][j-1][k-1] - cache[i][j-1][k];
                    }
                    else{
                        cache[i][j][k] = cache[i-1][j][k] + cache[i-1][j-1][k] + cache[i-1][j][k-1] - cache[i-1][j-1][k-1];
                    }
                }
            }
        }
        int temp = cache[70][70][70];
        for(int i=0; i<101; ++i){
            for(int j=0; j<101; ++j){
                for(int k=0; k<101; ++k){
                    if(i <= 50 || j <= 50 || k <= 50)
                        continue;
                    if(i > 70 || j > 70 || k > 70)
                        cache[i][j][k] = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        initfun();
        int x, y , z;
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            x = scanner.nextInt();
            y = scanner.nextInt();
            z = scanner.nextInt();
            if(x == -1 && y == -1 && z == -1) break;
            bw.append("w(" + x + ", " + y + ", " + z + ") = " + cache[x+50][y+50][z+50] + "\n");
        }
        scanner.close();
        bw.flush();
        bw.close();
    }
    
}
