package boj.unionfind;
import java.io.*;
import java.util.*;

// 친구 네트워크
public class N4195 {
    static HashMap<String, Integer> hashMap;
    static int key;
    static int[] root;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int F = Integer.parseInt(st.nextToken());
            hashMap = new HashMap<>();
            key = 0;
            root = new int[2 * F + 1];
            for(int i=0; i<2 * F + 1; i++) root[i] = i;
            num = new int[2 * F + 1];
            Arrays.fill(num, 1);
            while (F-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = findKey(st.nextToken());
                int b = findKey(st.nextToken());
                union(a, b);
                sb.append(num[find(a)]+"\n");
            }
        }
        System.out.print(sb);
    }

    static int findKey(String a) {
        if(!hashMap.containsKey(a)) hashMap.put(a, key++);
        return hashMap.get(a);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        root[b] = a;
        if(a!=b) num[a] += num[b];
    }

    static int find(int a) {
        if (a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}