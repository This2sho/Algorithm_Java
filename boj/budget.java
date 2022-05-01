package boj;
import java.util.*;
import java.util.stream.*;

public class budget {
    public static void main(String[] args) {

        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        int min = 0;
        int max = IntStream.of(budgets).max().orElse(1);

        while(min <= max){
            int mid = (max + min) / 2;
            int sum = 0;
            for(int budget : budgets){
                if(budget <= mid){
                    sum += budget;
                }else{
                    sum += mid;
                }
            }

            if(sum > M){
                max = mid-1;
            }else min = mid+1;
        }
        System.out.println(max);
    }
}
