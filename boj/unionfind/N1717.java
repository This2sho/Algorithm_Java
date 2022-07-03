package boj.unionfind;
import java.io.*;
import java.util.StringTokenizer;

//집합의 표현
public class N1717 {
    static int[] root;
    static final String yes = "YES";
    static final String no = "NO";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        root = new int[n+1];
        for(int i=1; i<=n; i++) root[i] = i;
        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(op == 0) union(a, b);
            else{
                if(find(a) == find(b)) System.out.println(yes);
                else System.out.println(no);
            }
        }
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        root[b] = a;
    }

    static int find(int a) {
        if(a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}
