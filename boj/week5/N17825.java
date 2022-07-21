package boj.week5;
import java.io.*;
import java.util.StringTokenizer;
// 주사위 윷놀이
public class N17825 {
    static int[] dice = new int[10];
    static int[] score = new int[410];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) dice[i] = Integer.parseInt(st.nextToken());
        initMap();
        calculate(0, 0, new boolean[410], new int[4]);
        System.out.print(res);
    }

    private static void initMap() {
        for (int i = 0; i <= 20; i++) score[i] = i * 2;
        // 103~199, 203~249, 253~299, 303~ 가면 안됨.
        for (int i = 101; i <= 103; i++) score[i] = 13 + 3 * (i - 101);
        for (int i = 201; i <= 202; i++) score[i] = 22 + 2 * (i - 201);
        for (int i = 250; i < 253; i++) score[i] = 25 + 5 * (i - 250);
        for (int i = 301; i <= 303; i++) score[i] = 28 - (i - 301);
        for (int i = 100; i <= 300; i += 100) score[i] = i / 10;
    }

    static void calculate(int depth, int sum, boolean[] map, int[] horse) {
        if (depth >= 10) {
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            boolean[] clone = map.clone();
            int[] clone1 = horse.clone();
            int move = move(i, dice[depth], clone, clone1);
            if(move == -1) continue;
            calculate(depth+1, sum + move, clone, clone1);
        }
    }

    static int move(int horse_idx, int dice_num, boolean[] map, int[] horse) {
        int cur_idx = horse[horse_idx];
        if(arrive(cur_idx)) return -1;
        int next_idx = cur_idx + dice_num;
        if (next_idx < 100) {
            if (next_idx == 5 || next_idx == 10 || next_idx == 15) next_idx = next_idx * 2 * 10;
        }else{
            if (next_idx > 103 && next_idx <= 199) {
                next_idx = 250 + (next_idx % 104);
            }else if (next_idx > 202 && next_idx <= 249) {
                next_idx = 250 + (next_idx % 203);
            } else if (next_idx > 303) {
                next_idx = 250 + (next_idx % 304);
            }
            if(next_idx >= 253 && next_idx <= 299){
                if(next_idx == 253) next_idx = 20;
                else next_idx = 21;
            }
        }
        if(!arrive(next_idx) && map[next_idx]) return -1;
        map[next_idx] = true;
        map[cur_idx] = false;
        horse[horse_idx] = next_idx;
        return score[next_idx];
    }

    static boolean arrive(int idx) {
        if(idx >= 21 && idx <= 25) return true;
        return false;
    }
}