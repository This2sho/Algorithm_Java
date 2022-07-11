package boj.week4;
import java.util.*;

public class N13244_unionFind {
    static int[] root = new int[1001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Arrays.fill(root, 0);
            for(int i=1; i<=N; i++) root[i] = i;
            boolean isTree = true;

            while (M-- > 0) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                if(!union(A, B)) isTree = false;
            }

            if (!isTree) {
                System.out.println("graph");
                continue;
            }
            int rootNum = find(1);
            for (int i = 2; i <= N; i++) {
                if (rootNum != find(i)) {
                    isTree = false;
                    break;
                }
            }

            if (isTree) System.out.println("tree");
            else System.out.println("graph");
        }
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a==b) return false;
        else{
            root[b] = a;
            return true;
        }
    }

    static int find(int a) {
        if(a == root[a]) return a;
        return root[a] = find(root[a]);
    }
}