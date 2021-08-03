package boj;
// 백준 9498번 문제
import java.util.Scanner;

public class TestScore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        scanner.close();


        if(score>=90){
            System.out.print('A');
        } else if(score >= 80){
            System.out.print('B');
        } else if(score >= 70){
            System.out.print('C');
        }else if(score >= 60){
            System.out.print('D');
        } else{
            System.out.print('F');
        }
    }
}
