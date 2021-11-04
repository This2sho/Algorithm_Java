package boj.Implementation;

import java.util.*;

public class GroupWord {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        String[] words = new String[N];
        for(int i=0; i<N; i++) words[i] = s.next();
        s.close();
        int answer = N;
        for(String word : words){
            HashSet<Character> find = new HashSet<>();
            for(int i=0; i<word.length(); i++){
                char before = '0';
                if(i != 0) before = word.charAt(i-1);
                char c = word.charAt(i);

                if(before != c) {
                    if(find.contains(c)) {
                        answer--;
                        break;
                    } 
                    find.add(c);
                }
            }
        }
        System.out.println(answer);
    }
}
