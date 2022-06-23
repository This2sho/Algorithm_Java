package boj.week4;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

// 집합
public class N11723 {
    static HashSet<Integer> set = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            calculate(st.nextToken(), st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0);
        }
        bw.flush();
    }

    static void calculate(String op, int n) throws IOException {
        if (op.equals("add")) {
            set.add(n);
        } else if (op.equals("remove")) {
            set.remove(n);
        } else if (op.equals("check")) {
            if(set.contains(n)) bw.write("1\n");
            else bw.write("0\n");
        } else if (op.equals("toggle")) {
            if (set.contains(n)) {
                set.remove(n);
            } else set.add(n);
        } else if (op.equals("all")) {
            for (int i = 1; i <= 20; i++) set.add(i);
        } else {
            set = new HashSet<>();
        }
    }
}
