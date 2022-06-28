package boj.week4.hidden.level6;

import java.util.Arrays;
import java.util.Scanner;

// 단어 공부
public class N1157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[26];
        char[] chars = sc.next().toLowerCase().toCharArray();
        for(int i=0; i< chars.length; i++) cnt[chars[i]-'a']++;
        int max = Arrays.stream(cnt).max().getAsInt();
        boolean find = false;
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if(cnt[i] == max && !find){
                res = i;
                find = true;
            }
            else if(cnt[i] == max && find) res = -1;
        }
        if(res == -1) System.out.print("?");
        else System.out.print((char) (res + 'A'));
    }
}
