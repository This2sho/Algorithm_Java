package programmers.Greedy;

public class Joystick {
    static class JoyStick{
        int answer = 0;
        int position = 0;
        boolean Dleft = false;
        char[] name;

        JoyStick(String name){
            this.name = new char[name.length()];
            for(int i=0; i<name.length(); i++){
                this.name[i] = 'A';
            }
        }

        int count(char c){
            // todo 현재 name position에서
            // c와 비교하여 위로갈지 아래로 갈지 더 작게 움직이게하는 값 반환
            // 위로는 +, 아래로는 -
            int up = c - this.name[this.position];
            int down = c-'A' + -26;
            return (up >= Math.abs(down)) ? down : up;
        }

        void goUp(int num){
            for(int i=0; i<num; i++){
                this.name[position]++;
                this.answer++;
            }
        }

        void goDown(int num){
            for(int i=0; i<num; i++){
                if(this.name[position] != 'A'){
                    this.name[position]--;
                }else{
                    this.name[position]='Z';
                }
                this.answer++;
            }
        }

        void goLeft(int num){
            for(int i=0; i<num; i++){
                if(this.position > 0){
                    this.position--;
                }else{
                    this.position = this.name.length-1;
                }
                this.answer++;
            }
        }

        void goRight(int num){
            for(int i=0; i<num; i++){
                if(this.position < name.length-1){
                    this.position++;
                }
                this.answer++;
            }
        }

        boolean equals(String name){
            String t = new String(this.name);
            return t.equals(name);
        }
        boolean equals(String name, int position){
            if(position >= name.length()) return false;
            if(position < 0) position = name.length()-1;
            return name.charAt(position)== this.name[position];
        }

        int findDiff(String name){
            int right = 0;
            int left = 0;

            // 초기 1 다른거 2 길이 : 4
            for(int i=this.position; left> -name.length(); i--){
                if(!equals(name, i)) break;
                left--;
            }
            if(this.Dleft == true) return left;
            // ABABAAAABBAB right 3 + 7 = 10 , left 11
            for(int i=this.position; right<=name.length()-1; i++){
                if(!equals(name, i)) {
                    if(this.position + right > name.length()) return left;
                    break;
                };
                right++;
            }
            int move = (right <= -left) ? right : left;
            if(move < 0 && this.position + move < 0) this.Dleft = true;
            return move;
        }
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        JoyStick j = new JoyStick(name);

        while(!j.equals(name)){
            int num = j.count(name.charAt(j.position));

            if(num >= 0) j.goUp(num);
            else j.goDown(-num);
            int move = j.findDiff(name);

            if(j.equals(name)) break;
            if(move >= 0) j.goRight(move);
            else if(move <0) j.goLeft(-move);
        }

        System.out.println("j = " + j.answer);
    }
}
