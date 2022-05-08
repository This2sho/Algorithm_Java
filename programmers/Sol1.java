package programmers;

import java.util.HashMap;

public class Sol1 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        int[] typeScore = new int[8];

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i< survey.length; i++){
            char type = getScore(survey[i], choices[i]).charAt(0);
            int score = getScore(survey[i], choices[i]).charAt(1) - '0';

            if(type == 'R'){
                typeScore[0] += score;
            }
            if(type == 'T'){
                typeScore[1] += score;
            }
            if(type == 'C'){
                typeScore[2] += score;
            }
            if(type == 'F'){
                typeScore[3] += score;
            }
            if(type == 'J'){
                typeScore[4] += score;
            }
            if(type == 'M'){
                typeScore[5] += score;
            }
            if(type == 'A'){
                typeScore[6] += score;
            }
            if(type == 'N'){
                typeScore[7] += score;
            }
        }

        String answer = "";

        answer += (typeScore[0] >= typeScore[1]) ? 'R' : 'T';
        answer += (typeScore[2] >= typeScore[3]) ? 'C' : 'F';
        answer += (typeScore[4] >= typeScore[5]) ? 'J' : 'M';
        answer += (typeScore[6] >= typeScore[7]) ? 'A' : 'N';

        System.out.println("answer = " + answer);
    }

    static String getScore(String type, int choice){
        if(choice == 4) return "00";
        else if(choice > 4){
            return new String(type.charAt(1) + String.valueOf(choice - 4));
        } else{
            return new String(type.charAt(0) + String.valueOf(-1 * (choice - 4)));
        }
    }
}


