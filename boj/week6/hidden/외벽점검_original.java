package boj.week6.hidden;

import java.util.Arrays;

// bitmasking으로 할려고 했으나 dist 배열의 순서도 중요하기 때문에
// 재귀로 dist의 배열 모드를 만들어줘야함...
public class 외벽점검_original {
    static int[][] weaks;

    public static void main(String[] args) {
//        System.out.println(solution(12, new int[] {1, 5, 6, 10}, new int[] {1, 2, 3, 4}));
//        System.out.println(solution(12, new int[] {1, 3, 4, 9, 10}, new int[] {3, 5, 7}));
        System.out.println(solution(200, new int[] {0, 10, 50, 80, 120, 160}, new int[] {1, 10, 5, 40, 30}));

    }

    static int solution(int n, int[] weak, int[] dist) {
        int answer = Integer.MAX_VALUE;
        makeWeaks(weak, n);
        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int[] ints : weaks) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        for (int i = 1; i < (1 << dist.length); i ++) {
            for (int[] ints : weaks) {
                if (isValid(ints, dist, i)) {
                    int tmp = 0;
                    for (int k = 1; k < (1 << dist.length); k *= 2) {
                        if((i & k) > 0) tmp++;
                    }
                    if (answer > tmp) {
                        System.out.println("tmp = " + tmp);
                        System.out.println("i = " + i);
                    }
                    answer = Math.min(answer, tmp);
                }
            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

    static void makeWeaks(int[] weak, int n) {
        weaks = new int[weak.length][weak.length];
        weaks[0] = weak.clone();
        for (int i = 1; i < weaks.length; i++) {
            weaks[i] = Arrays.copyOfRange(weaks[i - 1], 1, weak.length+1);
            weaks[i][weak.length-1] = weaks[i-1][0] + n;
        }
    }

    static boolean isValid(int[] weak, int[] dist, int bit) {
        int startIdx = 0;
        int next = 0;

        for (int j = 0; j < dist.length; j++) {
            if ((bit & (1 << j)) > 0) {
                next = next > weak[startIdx] ? next + dist[j] : weak[startIdx] + dist[j];
                if(next >= weak[weak.length-1]) return true;
                startIdx++;
                while (startIdx < weak.length && next >= weak[startIdx]) {
                    startIdx++;
                }
            }
        }
        return false;
    }
}
