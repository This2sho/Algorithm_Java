package programmers.Greedy;

import java.util.*;

public class station_install2 {
    public static void main(String[] args){
        int n = 16;
        int[] stations = {9};
        int w = 2;

        Solution sol = new Solution();
        System.out.println(sol.solution(n, stations, w));
    }
}

class Solution {
    static int beginIndex = 0;

    static Stack<Integer> unInstallStationGroup = new Stack<>();

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        checkUninstallStations(n, stations, w);
        while(!unInstallStationGroup.empty()){
            answer += stationInstallNum(unInstallStationGroup.pop(), w);
        }

        return answer;
    }

    public void checkUninstallStations(int n, int[] stations, int w){
        for(int stationIndex : stations){
            if(!addUninstallStationScope(stationIndex, w, n)){
                break;
            }
        }
        if(beginIndex <= n-1){
            unInstallStationGroup.add(n - beginIndex);
        }
    }

    public boolean addUninstallStationScope(int stationIndex, int w, int n){
        int min = stationIndex - w -1;
        int max = stationIndex + w -1;
        if(min > beginIndex){
            unInstallStationGroup.add(min - beginIndex);
        }
        beginIndex = max + 1;
        if(beginIndex > n-1){
            return false;
        }
        return true;
    }

    public int stationInstallNum(int unInstallStationScope, int w){
        int installNum = 0;
        int scope = w*2 + 1;
        installNum += unInstallStationScope / scope;
        if(unInstallStationScope % scope != 0){
            installNum++;
        }
        return installNum;
    }
}