package boj.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 수학숙제
public class N2870 {
    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            pushNum(str);
        }
        arrayList.stream().sorted((str1, str2) -> {
            if(str1.length() == str2.length()) return str1.compareTo(str2);
            return str1.length() - str2.length();
        }).forEach(n -> System.out.println(n));
    }

    static void pushNum(String str) {
        int cnt = 0;
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) {
                if(!temp.equals("") || c != '0') temp += c;
                cnt++;
            }else if(cnt > 0){
                if(!temp.equals("")) arrayList.add(temp);
                else arrayList.add("0");
                temp = "";
                cnt = 0;
            }
        }
        if(cnt > 0){
            if(!temp.equals("")) arrayList.add(temp);
            else arrayList.add("0");
        }
    }
}
