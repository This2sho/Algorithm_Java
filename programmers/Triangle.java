package programmers;

public class Triangle {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        for(int i=triangle.length-2; i>= 0; i--){
            System.out.println("i = " + i);

            for (int j=0; j < triangle[i].length; j++){
                System.out.println("j = " + j);
                if(triangle[i+1][j] > triangle[i+1][j+1]) triangle[i][j] += triangle[i+1][j];
                else triangle[i][j] += triangle[i+1][j+1];
            }
        }

        System.out.println("triangle[0][0] = " + triangle[0][0]);
    }

}
