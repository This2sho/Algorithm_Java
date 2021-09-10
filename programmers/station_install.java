package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class station_install {
    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            String temp = "(" + x + ", " + y +")";
            return temp;
        }
    }

    public static class Solution {
        ArrayList<Pair> al = new ArrayList<>();
        
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            
            int[] apart = new int[n];
            init_check(apart, stations, w);
            for(Pair p : al){
                int distance = p.y - p.x + 1;
                int wave = w*2+1;
                int q = distance/wave;
                int r = distance%wave;
                if(r != 0) r =1;
                answer += q+r;
                System.out.println("this = " + p);
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    
            return answer;
        }
        // todo
        // 배열은 원래 0으로 할당되있으니, 기지국에서 닿는 곳은 1로 할당해줄 것.
        // index가 배열의 bound를 넘지 않게 조건 잘걸것
        // 그리고 현재 index는 아파트 번호고 이를 -1해서 실제 index로 할 것.
        public void init_check(int[] apart, int[] station, int w){
            for(int i=0; i<station.length; ++i){
                int temp = station[i]-1;
                int min = temp-w;
                int max = temp+w;
                if(min < 0) min=0;
                if(max >= apart.length) max=apart.length-1;
                for(int j=min; j<=max; ++j) apart[j] = 1;
            }
            System.out.print("after init [");
            for(int i=0; i<apart.length-1; ++i){
                System.out.print(" "+ apart[i] + ",");
                int start = 0;
                int end = 0;
                boolean flag = true;
                if(apart[i] == 0 && flag) {
                    start=i+1;
                    end = start;
                    flag = !flag;
                }
                if(apart[i+1] == 1 && !flag){
                    end = i+1;
                    al.add(new Pair(start, end));
                    flag = !flag;
                }
            }
            System.out.println(apart[apart.length - 1]+" ]");
        }
    }

    public static void main(String[] args) throws IOException{
        int N,W;
        String String_station;
        String[] temp;
        int[] stations;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String_station = br.readLine().replace("[", "").replace("]", "");
        W = Integer.parseInt(br.readLine());
        temp = String_station.split(", ");
        stations = new int[temp.length];
        int k = 0;
        for(String i : temp){
            stations[k] = Integer.parseInt(i);
            k++;
        }
        Solution s = new Solution();
        System.out.println(s.solution(N, stations, W));
    }
}
