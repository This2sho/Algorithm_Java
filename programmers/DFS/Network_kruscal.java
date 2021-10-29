package programmers.DFS;

import java.util.*;

public class Network_kruscal {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[][] {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}}));
    }
}

class Network{
    int[] arr;
    
    Network(int n){
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i;
    }
    
    public int find(int n){
        if(arr[n] == n) return n;
        else return find(arr[n]);
    }
    
    public void merge(int a, int b){
        int parent_a = find(a);
        int parent_b = find(b);
        if(parent_a > parent_b) arr[a] = find(b);
        else arr[b] = find(a);
    }
}
class Solution {
    public int solution(int n, int[][] computers) {
        Network net = new Network(n);
        HashSet<Integer> answer = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1) {
                    net.merge(i, j);
                }
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(computers[i][j] == 1) {
                    net.merge(i, j);
                }
            }
        }
        
        for(int k : net.arr) {
            if(!answer.contains(k))
                answer.add(k);
        };
        
        return answer.size();
    }
}
