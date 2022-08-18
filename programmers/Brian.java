package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Brian {
    static LinkedList<Character> chars = new LinkedList<>();
    static boolean[] useChar = new boolean[26];
    static boolean[] visited = new boolean[26];
    static int[] checkChar = new int[26];
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        String sentence = "xAaAbAaAx";
        Solution s = new Solution();
        System.out.print(s.solution(sentence));
    }


    static class Solution {
        public String solution(String sentence) {
            findUsingWord(sentence);
            String answer = "";

            if(sentence.contains(" ")) return "invalid";
            if(sentence.length() == 1) return sentence;
            queue.add(sentence);
            while(!queue.isEmpty()){
                String word = queue.poll();
                int cnt1 = 0;
                int cnt2 = 0;
                for (Character ad : chars) {
                    if(visited[(ad - 'a')]) continue;
                    if (rule1(word, ad)) {
                        cnt1 ++;
                        word = rule1Resolve(word, ad);
                    }
                    if (rule2(word, ad) &&  checkChar[ad-'a']==2) {
                        cnt2++;
                        word = rule2Resolve(word, ad);
                    }
                    if(cnt1 > 1 || cnt2 > 1) return "invalid";
                }
                if(hasSmallAlpha(word)){
                    return "invalid";
                }
                answer += word.trim() + " ";
            }
            if(answer.equals(sentence + " ")) {
                answer = "";
                answer += sentence.substring(0, sentence.length()/2);
                answer += " ";
                answer += sentence.substring(sentence.length()/2);
                return answer;
            }
            return answer.trim().replaceAll("  ", " ");
        }
    }

    static boolean rule2(String sentence, char ad) {
        //todo (규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다.
        // ex) WORLD -> bWORLDb
        // 들어간 소문자가 2개 뿐이다.
        int beginIdx = sentence.indexOf(ad);
        if(beginIdx == -1) return false;
        int endIdx = sentence.lastIndexOf(ad);
        int adCnt = getAdCnt(sentence, ad, beginIdx, endIdx);
        if(adCnt != checkChar[ad - 'a']) return false;
        if(adCnt != 2) return false;

        if(endIdx - beginIdx == 1) return false;
        return true;
    }

    static boolean rule1(String sentence, char ad) {
        //todo (규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다.
        // ex) HELLO -> HaEaLaLaO
        // 특정 단어보다 들어간 소문자가 하나 더 적다.
        int beginIdx = sentence.indexOf(ad);
        if(beginIdx == -1) return false;
        int endIdx = sentence.lastIndexOf(ad);
        if(sentence.length()-1 == endIdx) return false;
        int adCnt = getAdCnt(sentence, ad, beginIdx, endIdx);
        if(adCnt != checkChar[ad - 'a']) return false;

        int wordBeginIdx = beginIdx - 1;
        int wordEndIdx = endIdx + 1;
        if(wordBeginIdx < 0 || wordEndIdx >= sentence.length()) return false;
        int wordSize = wordEndIdx - wordBeginIdx + 1 - adCnt;

        if(wordSize-1 == adCnt) return true;
        return false;
    }

    static String rule1Resolve(String word, char ad) {
        //todo (규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다.
        // ex) HELLO -> HaEaLaLaO
        // 특정 단어보다 들어간 소문자가 하나 더 적다.
        int beginIdx = word.indexOf(ad);
        int endIdx = word.lastIndexOf(ad);
        int start = beginIdx - 1;
        int end = endIdx + 1;
        String result = "";
        for(int i=0; i<start; i++){
            result += word.charAt(i);
            if(i == start-1) result += " ";
        }
        String temp = "";

        for(int i=end+1; i<word.length(); i++){
            temp += word.charAt(i);
            if(i == word.length()-1) queue.add(temp);
        }
        return result + word.substring(start, end + 1).replaceAll(ad + "", "");
    }

    static String rule2Resolve(String word, char ad) {
        //todo (규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다.
        // ex) WORLD -> bWORLDb
        // 들어간 소문자가 2개 뿐이다.
        int beginIdx = word.indexOf(ad);
        int endIdx = word.lastIndexOf(ad);
        String result = "";
        for(int i=0; i<beginIdx; i++){
            result += word.charAt(i);
            if(i == beginIdx-1) result += " ";
        }
        String temp = "";
        for(int i=endIdx+1; i<word.length(); i++){
            temp += word.charAt(i);
            if(i == word.length()-1) queue.add(temp);
        }
        return result + word.substring(beginIdx + 1, endIdx);
    }

    static int getAdCnt(String sentence, char ad, int beginIdx, int endIdx) {
        int cnt = 0;
        for (int i=beginIdx; i <= endIdx; i++) {
            if(sentence.charAt(i) == ad) cnt++;
        }
        return cnt;
    }

    static void findUsingWord(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c - 'a' >= 0 && c - 'a' < 26) {
                if(!useChar[(c - 'a')]) chars.add(c);

                checkChar[(c - 'a')]++;
                useChar[(c - 'a')] = true;
            }
        }
    }

    static boolean hasSmallAlpha(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c - 'a' >= 0 && c - 'a' < 26) return true;
        }
        return false;
    }
}
