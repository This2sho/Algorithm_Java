package boj.week2;

import java.util.Scanner;

// NBA 농구
public class N2852 {
    static int[] lastTime = {0,0};
    static int[] score = {0, 0};
    static int[][] answer = {{0, 0}, {0, 0}};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int team = sc.nextInt();
        String[] split = sc.next().split(":");
        int mm = Integer.parseInt(split[0]);
        int ss = Integer.parseInt(split[1]);
        score[team-1]++;
        lastTime[0] = mm;
        lastTime[1] = ss;

        for (int i = 1; i < N; i++) {
            team = sc.nextInt();
            split = sc.next().split(":");
            mm = Integer.parseInt(split[0]);
            ss = Integer.parseInt(split[1]);
            solve(team, mm, ss);
        }
        solve(1, 48, 0);
        printAnswer();
    }

    public static void solve(int team, int mm, int ss) {
        if(score[0] > score[1]){
            // 1팀이 이기고 있었던 경우
            answer[0][0] = mm - lastTime[0];
            if(lastTime[1] > ss){
                answer[0][0]--;
                answer[0][1] = ss - lastTime[1] + 60;
            }else answer[0][1] = ss - lastTime[1];
        } else if (score[1] > score[0]) {
            // 2팀이 이기고 있었던 경우
            answer[1][0] = mm - lastTime[0];
            if(lastTime[1] > ss){
                answer[1][0]--;
                answer[1][1] = ss - lastTime[1] + 60;
            }else answer[1][1] = ss - lastTime[1];
        }else {
            lastTime[0] = mm;
            lastTime[1] = ss;
        }
        score[team-1]++;
    }

    public static void printAnswer() {
        for (int[] ints : answer) {
            String answer = "";
            for (int anInt : ints) {
                if(anInt < 10) answer += "0" + anInt +" ";
                else answer += anInt + " ";
            }
            System.out.println(answer.trim().replace(" ", ":"));
        }
    }
}