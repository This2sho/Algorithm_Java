package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleOfThree {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = getOneNum(X);
        System.out.println(count);
        if(Integer.parseInt(Y) % 3 == 0) System.out.print("YES");
        else System.out.print("NO");
    }

    static boolean isOneNum(String x) {
        if (x.length() > 1) {
            return false;
        }
        return true;
    }

    static String getOneNum(String x) {
        if(isOneNum(x)) return x;
        count++;
        return getOneNum(getOneSum(x));
    }

    static String getOneSum(String x) {
        int sum = 0;
        for (int i = 0; i < x.length(); i++) {
            sum += Integer.parseInt(String.valueOf(x.charAt(i)));
        }
        return String.valueOf(sum);
    }


}
