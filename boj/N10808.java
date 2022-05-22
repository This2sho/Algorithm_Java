package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;

// 알파벳 개수
public class N10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = br.readLine();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 'a' + 0; i < 'z' + 1; i++) {
            map.put((char) i, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        for (Character character : map.keySet()) {
            System.out.print(map.get(character) + " ");
        }

    }
}
