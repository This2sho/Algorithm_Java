package boj;
import java.util.Scanner;

/*
boj # 2775
입력
첫 번째 줄에 Test case의 수 T가 주어진다. 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다

출력
각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
*/

/*
2층의 3호에 살려면 1층의 1호부터 3호까지 사람들의 수의 합만큼 사람들을 데려와 살아야함.
-> 1층의 1호 + 2호 + 3호 -> 10명

1층의 1호에 살려면 0층의 1호 -> 1명
1층의 2호에 살려면 0층의 1호 + 2호 -> 3명
1층의 3호에 살려면 0총의 1호 + 2호 + 3호 -> 6명

3층의 2호
2층의 1호=> 1 + 2층의 2호 = 1층의 1호=> 1 + 1층의 2호 = 3
*/
class Main{
    public static int how_many_people_live(int a, int b){
        // if(a < 0) {
        //     System.out.println("입력된 층이 음수 입니다.");
        //     return -1;
        // }
        
        // 0층이 될때까지 재귀 
        if(a == 0){
            return b;
        }
        else if(b == 1){
            return 1;
        }
        else if (b == 2){
            return a + b;
        }
        // a가 0이 아니고 b가 2보다 클때 
        else {
            return how_many_people_live(a-1, b) + how_many_people_live(a, b-1);
        }
    }    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0; i<T; ++i){
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(how_many_people_live(k, n));
        }
        scanner.close();


    }
}