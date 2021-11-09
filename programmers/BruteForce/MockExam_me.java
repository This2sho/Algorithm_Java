package programmers.BruteForce;


class Point{
    int aPoint = 0;
    int bPoint = 0;
    int cPoint = 0;
    int[] aRule = {1, 2, 3, 4, 5};
    int[] bRule = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] cRule = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    int[] answers;
    
    Point(int[] answers){
        this.answers = new int[answers.length];
        this.answers = answers;
        setPointA();
        setPointB();
        setPointC();
    }
    
    public void setPointA(){
        for(int i=0; i<answers.length; i++){
            int j = i % 5;
            if(answers[i] == aRule[j]) aPoint++;
        }
    }
    
    public void setPointB(){
        for(int i=0; i<answers.length; i++){
            int j = i % 8;
            if(answers[i] == bRule[j]) bPoint++;
        }
    }
    
    public void setPointC(){
        for(int i=0; i<answers.length; i++){
            int j = i % 10;
            if(answers[i] == cRule[j]) cPoint++;
        }
    }
    
}

class Solution {
    public int[] solution(int[] answers) {
        Point p = new Point(answers);
        int[] temp = {p.aPoint, p.bPoint, p.cPoint};
        int max = temp[0];
        int[] idx = new int[3];
        int cnt = 1;
        for(int i=1; i<3; i++){
            if(max < temp[i]){
                max = temp[i];
                idx[0] = i;
            }else if(max == temp[i]){
                idx[cnt++] = i;
            }
        }
        int[] answer = new int[cnt];
        for(int i=0; i<cnt; i++){
            answer[i] = idx[i]+1;
        }
        return answer;
    }
}

public class MockExam_me {
    public static void main(String[] args){
        Solution s = new Solution();
        int [] answer = s.solution(new int[] {1,2,3,4,5});
        for(int n : answer) System.out.println(n);
    }
}
