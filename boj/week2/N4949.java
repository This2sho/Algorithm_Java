package boj.week2;

import java.util.Scanner;
import java.util.Stack;

// 균형잡힌 세상
public class N4949 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        while(!temp.equals(".")){
            System.out.println(isValid(temp));
            temp = sc.nextLine();
        }
    }

    public static String isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('(');
            else if(str.charAt(i) == ')') {
                if(stack.empty() || stack.pop() != '(') return "no";
            }
            else if (str.charAt(i) == '[') stack.push('[');
            else if(str.charAt(i) == ']') {
                if(stack.empty() || stack.pop() != '[') return "no";
            }
        }
        if(stack.empty()) return "yes";
        return "no";
    }
}
