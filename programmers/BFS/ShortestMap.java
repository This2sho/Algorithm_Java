package programmers.BFS;
import java.util.*;

public class ShortestMap {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{1,1,1,1,1},{1,0,1,0,1},{1,0,1,0,1},{1,1,1,0,1}}));
    }
    
}
    
class Position{
    int x;
    int y;
    
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    boolean isValid(int maxWidth, int maxHeight){
        if(this.x >= maxWidth || this.x <= -1) return false;
        if(this.y >= maxHeight || this.y <= -1) return false;
        return true;
    }
        
}
class Solution {
    public int solution(int[][] maps) {
        /*
            이런 문제에서 값을 찾아가며 계산해보는건 매우 힘듬..
            규칙을 잘생각하며 모든 것이 적용되는 규칙을 생성하는게 중요!.
            BFS -> Queue사용 가능한 방향에서 최단 거리로 멈출 수 있음. Possible(갈수 있는 곳) 
            현재 위치 -> Position now
            움직일 위치 -> Position move
            지나온길 -> visited[][]
            사용한 칸수 -> step[][]
            
        */
        final int MAPWIDTH = maps[0].length;
        final int MAPHEIGHT = maps.length;

        boolean[][] visited = new boolean[MAPHEIGHT][MAPWIDTH];
        int[][] step = new int[MAPHEIGHT][MAPWIDTH];
        
        Queue<Position> possible = new LinkedList<>();
        Position now = new Position(0, 0);
        
        possible.offer(now);
        step[0][0] = 1;
        visited[0][0] = true;
        
        while(!possible.isEmpty()){
            now = possible.poll();
            
            final int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int i=0; i < direction.length; i++){
                Position moved = new Position(now.x + direction[i][0], now.y + direction[i][1]);
                if(moved.isValid(MAPWIDTH, MAPHEIGHT) && !visited[moved.y][moved.x] && maps[moved.y][moved.x] != 0){
                    possible.offer(moved);
                    step[moved.y][moved.x] = step[now.y][now.x] + 1;
                    visited[moved.y][moved.x] = true;
                }
                if(moved.y == MAPHEIGHT-1 && moved.x == MAPWIDTH - 1) break;
            }
        }
        int answer = step[MAPHEIGHT-1][MAPWIDTH-1];
        if(answer == 0) return -1;
        
        return answer;
    }
}