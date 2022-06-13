package boj.week3;

import java.util.Scanner;

// 부등호
public class N2529 {
    static char[] marks;
    static int K;
    static String max = "", min = "";
    static boolean[] visited = new boolean[10];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        marks = new char[K];
        sc.nextLine();
        String next = sc.nextLine();
        for (int i = 0; i < next.length(); i+=2) {
            marks[i/2] = next.charAt(i);
        }

        for(int i=0; i<10; i++) {
            visited[i] = true;
            if(initMin(i, 0, i + "")) {
                visited[i] = false;
                break;
            }
            visited[i] = false;
        }

        for(int i=9; i>=0; i--) {
            visited[i] = true;
            if(initMax(i, 0, i + "")) break;
            visited[i] = false;
        }
        System.out.print(max +"\n" + min);
    }

    static boolean initMin(int num, int idx, String res) {
        if(!min.equals("")) return true;
        if (res.length() == K + 1) {
            min = res;
            return true;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if(!isValid(marks[idx], num, i) || !min.equals("")) break;
            visited[i] = true;
            initMin(i, idx + 1, res+i);
            visited[i] = false;
        }
        return false;
    }

    static boolean initMax(int num, int idx, String res) {
        if(!max.equals("")) return true;
        if (res.length() == K + 1) {
            max = res;
            return true;
        }
        for (int i = 9; i >= 0; i--) {
            if (visited[i]) continue;
            if(!isValid(marks[idx], num, i) || !max.equals("")) break;
            visited[i] = true;
            initMax(i, idx + 1, res+i);
            visited[i] = false;
        }
        return false;
    }

    static boolean isValid(char mark, int num1, int num2) {
        if(mark == '<') return (num1 < num2);
        else return (num1 > num2);
    }
}
