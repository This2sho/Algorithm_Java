package programmers.DFS;

public class Network_dfs {
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][] {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}));

    }

    static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    answer++;
                    dfs(i, visited, computers);
                }
            }
            return answer;
        }
        
        public void dfs(int i, boolean[] visited, int[][] computers){
            visited[i] = true;
            for(int j=0; j < visited.length; j++){
                if(computers[i][j] == 1 && !visited[j]) dfs(j, visited, computers); 
            }
        }
    }
}
