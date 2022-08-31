package boj.week6.hidden;

public class 괄호변환 {
    public String solution(String p) {
        //        if(isRightString(p)) return p;
        String answer = "";
        answer = go(p);
        return answer;
    }

    public String go(String w) {
        // N. 1
        if (w.isEmpty()) return w;

        // N. 2
        int openCnt = 0;
        String u = "";
        String v = "";
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            if(c == '(') openCnt++;
            else openCnt--;
            u += c;
            if(openCnt == 0) {
                v = w.substring(i+1);
                break;
            }
        }

        // N.3
        if(isRightString(u)) return u + go(v);

        // N.4
        String start = "(";
        String goV = go(v);
        start += goV + ")";

        String sub = u.substring(1, u.length() - 1);
        String end = "";
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if(c == '(') end += ')';
            else end += '(';
        }
        return start + end;
    }

    public boolean isRightString(String p) {
        int openCnt = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == '(') openCnt++;
            else openCnt--;
            if(openCnt < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        괄호변환 test = new 괄호변환();
        System.out.println(test.solution("(()())()"));
        System.out.println(test.solution(")("));
        System.out.println(test.solution("()))((()"));
    }
}
