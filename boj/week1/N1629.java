package boj.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 곱셈
public class N1629 {
    static long [] abc = new long[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) abc[i] = Integer.parseInt(st.nextToken());
        System.out.print(pow(abc[0], abc[1]));
    }

    /**
     * a ^ 4 = (a^2) ^ 2
     * a ^ 5 = (a^2) ^ 2 * a
     *
     *  a^8 = a^4 * a^4 = (a^2 * a^2) * (a^2 * a^2)
     *     = ((a * a) * (a * a)) * ((a * a) * (a * a))
     *
     *   a*9 = a^4 * a^4 * a
     *
     *   (a * b) % c = (a % c * b % c) % c
     */
    public static long pow(long a, long exponent) {
        if(exponent == 1) return a % abc[2];

        long temp = pow(a, exponent / 2);

        if(exponent % 2 == 1) return (temp * temp % abc[2]) * a % abc[2];

        return temp * temp % abc[2];
    }
}
