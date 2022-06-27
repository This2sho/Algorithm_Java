package boj.week4.hidden.level5;

// 정수 N개의 합
public class N15596 {
     static long sum(int[] a) {
        long sum = 0;
        for (int i : a) sum += i;
        return sum;
    }
}
