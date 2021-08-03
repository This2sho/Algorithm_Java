package boj;
import java.util.Scanner;

/*
boj 4344번 문제
평균은 넘겠지

입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
*/
public class average_over {
    public static double average(int[] arr){
        int sum = 0;
        double avg;
        for(int score : arr){
            sum += score;
        }
        avg = (double)sum/ (double)arr.length;
        return avg;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        for(int i=0; i<C; ++i){
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for(int j=0; j<N; ++j){
                arr[j] = scanner.nextInt();
            }
        scanner.close();

            double avg= average(arr);
            int cnt = 0;
            for(int score : arr){
                if(score > avg){
                   cnt++;     
                }
            }
            double avg_pro = (double)cnt / N * 100;
            System.out.printf("%.3f",avg_pro);
            System.out.println("%");           
        }
    }
    
}
