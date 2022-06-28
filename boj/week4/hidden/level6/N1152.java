package boj.week4.hidden.level6;

import java.util.Scanner;

// 단어의 개수
public class N1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(!s.equals("") && !s.equals(" ")) System.out.print(s.trim().split(" ").length);
        else System.out.print(0);
    }
}