package boj.Implementation;

import java.beans.Visibility;
import java.util.*;

class Robot{
    int x;
    int y;
    int d;
    int[][] map;
    boolean[][] visited;
    final int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};


    Robot(int x, int y, int d, int height, int width){
        this.x = x;
        this.y = y;
        this.d = d;

        map = new int[height][width];
        visited = new boolean[height][width];
    }

    public void clean(){
        visited[y][x] = true;
    }

    public void search(){
        
    }

}
public class RobotCleaner {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int HEIGHT = s.nextInt();
        int WIDTH = s.nextInt();
        Robot robot = new Robot(s.nextInt(), s.nextInt(), s.nextInt(), HEIGHT, WIDTH);

        for(int i=0; i<HEIGHT; i++){
            for(int j=0; j<WIDTH; j++) robot.map[i][j] = s.nextInt();
        }




    }
}
