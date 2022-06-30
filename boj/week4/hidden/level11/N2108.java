package boj.week4.hidden.level11;

import java.util.*;

// 통계학
public class N2108 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        IntSummaryStatistics st = Arrays.stream(arr).summaryStatistics();
        int[] sortA = Arrays.stream(arr).sorted().toArray();
        System.out.println(Math.round(st.getAverage()));
        System.out.println(sortA[N/2]);
        Integer max = map.values().stream().max((a, b) -> a - b).get();
        Integer[] integers = map.keySet().stream().filter(a -> map.get(a) == max).distinct().sorted().toArray(Integer[]::new);
        if(integers.length > 1) System.out.println(integers[1]);
        else System.out.println(integers[0]);
        System.out.print(sortA[N-1] - sortA[0]);
    }
}
