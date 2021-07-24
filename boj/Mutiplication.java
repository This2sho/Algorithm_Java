package boj;
// 백준 2588번 문제
import java.util.*;

class Mutiplication{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        
        int second_1 = second % 10;
        int second_2 = second % 100 / 10;
        int second_3 = second / 100;
        
        int one = first * second_1;
        int two = first * second_2;
        int three = first * second_3;

        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.print(one+two*10+three*100);

    }
}
