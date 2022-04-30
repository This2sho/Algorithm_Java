public class GotchaCaluculator {
    /**
     *  확률이 p인 독립 사건을 n번 반복시행했을 때
     *  r번 일어날 확률은 다음과 같다
     *  nCr * p^r * (1-p)^(n-r)
     *
     *  만약, 1번이라도 일어날확률을 구한다면
     *  전체확률 에서 모두 실패할 확률을 빼주면 된다.
     *  즉, 1 - (1-p)^(n)
     *
     */
    public static void main(String[] args) {

        int n = 1000;
        double p = 0.00054;

        System.out.println(p*100 + "%의 확률을 가진 아이템을 "+ n +"번 뽑기하면");
        double result = 1 - Math.pow((1 - p), n);
        System.out.println(result*100 + "% 확률로 얻을 수 있다!");
    }
}
