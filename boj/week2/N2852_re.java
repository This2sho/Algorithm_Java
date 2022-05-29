package boj.week2;

import java.util.Scanner;

// NBA 농구
public class N2852_re {
    public static final int NO = -1;
    public static final int lastTime = 48 * 60;
    public static int winTeam;
    public static int[] score = new int[3];
    public static int[] winTime = {-1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        winTeam = NO; // 비기는 경우
        int saveTime =0;
        for (int i = 0; i < N; i++) {
            int team = sc.nextInt();
            String[] split = sc.next().split(":");
            int goalTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

            if (i != 0 && winTeam != NO) winTime[winTeam] += goalTime - saveTime;
            score[team]++;
            saveTime = goalTime;
            if(score[1] > score[2]) winTeam = 1;
            else if(score[2] > score[1]) winTeam =2;
            else winTeam = NO;
        }
        if(winTeam != NO){
            winTime[winTeam] += lastTime - saveTime;
        }
        System.out.printf("%02d:%02d%n%02d:%02d", (winTime[1]/60), (winTime[1]%60), (winTime[2]/60), (winTime[2]%60));
    }
}
