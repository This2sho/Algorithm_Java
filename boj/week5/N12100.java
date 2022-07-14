package boj.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2048 (Easy)
public class N12100 {
    static int[][] map;
    static int N, res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        solve(0, map);
        System.out.print(res);
    }

    static void solve(int depth, int[][] temp) {
        if (depth == 5) {
            res = Math.max(res, getMax(temp));
            return;
        }

        for(int i=0; i<4; i++){
            solve(depth+1, move(i, temp));
        }
    }
    static void printMap(int[][] temp) {
        for (int[] ints : temp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int getMax(int[][] temp) {
        int max = 0;
        for (int i = 0; i < temp.length; i++) max = Math.max(max, Arrays.stream(temp[i]).max().getAsInt());
        return max;
    }

    static int[][] move(int d, int[][] temp) {
        int[][] next_map = new int[temp.length][temp[0].length];
        for(int i=0; i<next_map.length; i++) System.arraycopy(temp[i], 0, next_map[i], 0, temp[i].length);

        // 왼쪽으로
        if (d == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if(next_map[i][j] == 0){
                        for(int k = j+1; k <N; k++){
                            if (next_map[i][k] != 0) {
                                next_map[i][j] = next_map[i][k];
                                next_map[i][k] = 0;
                                for(int l = k+1; l <N; l++){
                                    if(next_map[i][l] != 0){
                                        if(next_map[i][l] == next_map[i][j]) {
                                            next_map[i][j] += next_map[i][l];
                                            next_map[i][l] = 0;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }else{
                        for(int k = j+1; k <N; k++){
                            if (next_map[i][k] != 0) {
                                if(next_map[i][j] == next_map[i][k]){
                                    next_map[i][j] += next_map[i][k];
                                    next_map[i][k] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 위로
        else if(d == 1){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if(next_map[j][i] == 0){
                        for(int k = j+1; k <N; k++){
                            if (next_map[k][i] != 0) {
                                next_map[j][i] = next_map[k][i];
                                next_map[k][i] = 0;
                                for(int l = k+1; l <N; l++){
                                    if(next_map[l][i] != 0){
                                        if(next_map[l][i] == next_map[j][i]) {
                                            next_map[j][i] += next_map[l][i];
                                            next_map[l][i] = 0;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }else{
                        for(int k = j+1; k <N; k++){
                            if (next_map[k][i] != 0) {
                                if(next_map[j][i] == next_map[k][i]){
                                    next_map[j][i] += next_map[k][i];
                                    next_map[k][i] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 오른쪽
        else if(d == 2){
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j > 0; j--) {
                    if(next_map[i][j] == 0){
                        for(int k = j-1; k >= 0; k--){
                            if (next_map[i][k] != 0) {
                                next_map[i][j] = next_map[i][k];
                                next_map[i][k] = 0;
                                for(int l = k-1; l >= 0; l--){
                                    if(next_map[i][l] != 0){
                                        if(next_map[i][l] == next_map[i][j]) {
                                            next_map[i][j] += next_map[i][l];
                                            next_map[i][l] = 0;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }else{
                        for(int k = j-1; k >= 0; k--){
                            if (next_map[i][k] != 0) {
                                if(next_map[i][j] == next_map[i][k]){
                                    next_map[i][j] += next_map[i][k];
                                    next_map[i][k] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        // 아래로
        else{
            for (int i = 0; i < N; i++) {
                for (int j = N-1; j > 0; j--) {
                    if(next_map[j][i] == 0){
                        for(int k = j-1; k >= 0; k--){
                            if (next_map[k][i] != 0) {
                                next_map[j][i] = next_map[k][i];
                                next_map[k][i] = 0;
                                for(int l = k-1; l >= 0; l--){
                                    if(next_map[l][i] != 0){
                                        if(next_map[l][i] == next_map[j][i]) {
                                            next_map[j][i] += next_map[l][i];
                                            next_map[l][i] = 0;
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }else{
                        for(int k = j-1; k >= 0; k--){
                            if (next_map[k][i] != 0) {
                                if(next_map[j][i] == next_map[k][i]){
                                    next_map[j][i] += next_map[k][i];
                                    next_map[k][i] = 0;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        return next_map;
    }
}
