package boj.week3;

import java.util.*;

// 뮤탈리스크
public class N12869 {
    static Queue<Scv> queue = new LinkedList<>();
    static final int[] attacks = {9, 3, 1};
    static int[][][] dp = new int[64][64][64];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Scv scv = new Scv(0, 0);
        for (int i = 0; i < N; i++) {
            scv.addScv(sc.nextInt());
        }
        queue.add(scv);
        while (!queue.isEmpty()) {
            Scv poll = queue.poll();
            poll.print();
            if(poll.lives == 0){
                System.out.print(poll.cnt);
                break;
            }
            boolean[] visited = new boolean[3];
            attack(poll, 0, visited);
        }
    }

    static void attack(Scv scv, int idx, boolean[] visited) {
        if(idx == scv.lives){
            Scv nScv = new Scv(0, scv.cnt + 1);
            for (Integer s : scv.scvs) {
                if(s > 0) nScv.addScv(s);
            }
            int[] scvHp = new int[3];
            int i = 0;
            for (Integer hp : nScv.scvs) {
                scvHp[i++] = hp;
            }
            for (; i < 3; i++) {
                scvHp[i] = 0;
            }
            if(dp[scvHp[0]][scvHp[1]][scvHp[2]] > 0 && dp[scvHp[0]][scvHp[1]][scvHp[2]] <= nScv.cnt) return;
            queue.add(nScv);
            dp[scvHp[0]][scvHp[1]][scvHp[2]] = nScv.cnt;
            return;
        }
        for (int i = 0; i < scv.lives; i++) {
            //todo scv 3개 다 다르게 쳐봐야함.
            if(!visited[i]){
                visited[i] = true;
                scv.attack(idx, attacks[i]);
                attack(scv, idx + 1, visited);
                visited[i] = false;
                scv.attack(idx, -attacks[i]);
            }
        }
    }

    static class Scv{
        LinkedList<Integer> scvs;
        int lives, cnt;

        public Scv(int lives, int cnt) {
            scvs = new LinkedList<>();
            this.lives = lives;
            this.cnt = cnt;
        }

        public void addScv(int scv){
            scvs.add(scv);
            lives++;
            scvs.sort(Comparator.reverseOrder());
        }

        public void attack(int idx, int damage){
            Integer scv = scvs.get(idx);
            scvs.set(idx, scv - damage);
        }

        public void print() {
            for (int i = 0; i < lives; i++) {
                System.out.print((i+1) + "번째 scv : " + scvs.get(i) + " ");
            }
            System.out.println("남은 scv : " + lives +" 현재 시도횟수 : " + cnt);
        }
    }
}
