package boj.week4.hidden.level12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 대칭 차집합
public class N1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while(N -- > 0) A.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        while(M -- > 0) B.add(Integer.parseInt(st.nextToken()));
        int size = A.size() + B.size();
        for (Integer integer : A) if(B.contains(integer)) size -= 2;
        System.out.print(size);
    }
}
