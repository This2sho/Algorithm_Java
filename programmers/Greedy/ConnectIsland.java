package programmers.Greedy;

import java.util.*;

/*
    Kruscal algorithm(크루스칼 알고리즘) 
    그리디 알고리즘을 이용하여 가중치가 존재하는 그래프를 최소의 비용으로 연결하는 최적의 해답을 구하는 알고리즘.

    최소 비용 신장 트리(MST)가 최소 비용의 간선으로 구성되어 있고, 사이클을 포함하지 않은 조건에서 각 단계에서
    사이클을 이루지 않는 최소 비용 간선을 선택한다.

    크루스칼 동작 순서
    1. 그래프의 간선들을 가중치의 오름차순으로 정렬한다.
    2. 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택한다.
    3. 해당 간선을 현재의 MST의 집합에 추가한다.
*/
public class ConnectIsland {
    public static void main(String[] args){
        Solution s = new Solution();
        int  a = s.solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        System.out.println(a);
    }

    static class Solution {
        public int solution(int n, int[][] costs) {
            int answer = 0;
            int pick = n-1;
            Check check = new Check(n);
            LinkedList<Island> isList = new LinkedList<>();
            for(int i=0; i<costs.length; i++){
                Island temp = new Island(costs[i][0], costs[i][1], costs[i][2]);
                isList.add(temp);
            }
            Collections.sort(isList);
            int i=0;
            while(pick > 0 && i<isList.size()){
                Island temp = isList.get(i);
                if(!check.isConnect(temp.x, temp.y)){
                    answer += temp.cost;
                    pick--;
                }
                i++;
            }
            return answer;
        }
    }
}

class Island implements Comparable<Island>{
    int x;
    int y;
    int cost;

    Island(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Island o) {
        return this.cost - o.cost;
    }
}

class Check{
    int[] check;
    Check(int n){
        check = new int[n];
        for(int i=0; i<n; i++) check[i] = i;
    }

    public int find(int a){
        if(a == check[a]) return a;
        else return find(check[a]);
    }

    public boolean isConnect(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else{
            merge(a, b);
            return false;
        }
    } 
    public void merge(int a, int b){
        if(a > b) check[a] = b;
        else check[b] = a;
    }
}