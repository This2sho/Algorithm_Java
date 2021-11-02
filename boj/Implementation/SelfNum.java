package boj.Implementation;

public class SelfNum {
    public static void main(String[] args){
        int[] kar = new int[10000];
        for(int i=1; i<10000; i++){
            int n = Kar(i);
            if(n < 10000) kar[n] = n;
        }
        for(int i=1; i<10000; i++){
            if(kar[i] == 0) System.out.println(i);
        }
    }

    public static int Kar(int n){
        int result = n;
        if(n / 1000 >= 1){
            result += n/1000;
            n = n % 1000;
        }
        if(n / 100 >= 1){
            result += n/100;
            n = n % 100;
        }
        if(n / 10 >= 1){
            result += n/10;
            n = n % 10;
        }

        return result+n;
    }
}
