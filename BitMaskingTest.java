public class BitMaskingTest {
    public static void main(String[] args) {
        int t = 7; // 101
        printBit(t);
        print(t);

        t = 6; // 101
        printBit(t);
        print(t);

        t = 5; // 101
        printBit(t);
        print(t);

        t = 4; // 101
        printBit(t);
        print(t);

    }

    static void printBit(int t) {
        System.out.print("t = " + t + " : ");
        for (int i = 7; i >= 0; i--) {
            if(((1 << i) & t) > 0) System.out.print(1 + " ");
            else System.out.print(0 + " ");
            if(i==4) System.out.print("| ");
        }
        System.out.println();
    }

    static void print(int t) {
        t1(t);
        t2(t);
        t3(t);
        t4(t);
        t5(t);
        t6(t);
        System.out.println();
    }

    /**
     * idx번째 비트 끄기
     */
    static void t1(int t){
        int idx = 0;
        int temp = t;
        temp &= ~(1 << idx);
        System.out.println("T1 -> " + idx + "번째 비트 끄기 : " + temp);
    }

    /**
     * idx번째에 대한 XOR 연산
     */
    static void t2(int t){
        int idx = 0;
        int temp = t;
        temp ^= (1 << idx);
        System.out.println("T2 -> " +idx + "번째에 대한 XOR 연산 : " + temp);
    }

    /**
     * 최하위 켜져있는 idx 찾기
     * 7 : 0000 0111
     * -7 : 1111 1001
     *
     * 6 : 0000 0110
     * -6 : 1111 1010
     *
     *  5 : 0000 0101
     * -5 : 1111 1011 -128 + 127 -4
     *
     *  4 : 0000 0100
     * -4 : 1111 1100 -128 + 127 -4
     *
     *  1 : 0000 0001
     * -1 : 1111 1111
     */
    static void t3(int t){
        int res = (t & -t) ;
        int idx = (int) (Math.log(res) / Math.log(2));
        System.out.println("T3 -> " +"최하위 켜져있는 비트 값 : " + res + ", 최하위 켜져있는 idx 값 : " + idx);
    }

    /**
     * n인 집합의 모든 비트를 켜기
     */
    static void t4(int t){
        int n = 4;
        System.out.println("T4 -> 크기가 " + n + "인 모든 집합의 모든 비트 켜기 : " + ((1 << n) - 1 ));
    }

    /**
     * idx번째 비트를 켜기
     */
    static void t5(int t){
        int idx = 1;
        int temp = t;
        temp |= (1 << idx);
        System.out.println("T5 -> " + idx + "번째 비트를 켜기 : " + temp);
    }

    /**
     * idx번째 비트가 있는지 확인하기
     */
    static void t6(int t){
        int idx = 0;
        int temp = t;
        String a = (temp & (1 << idx)) != 0 ? "yes" : "no";
        System.out.println("T6 -> " + idx + "번째 비트가 있는지 확인하기 : " + a);
    }


}
