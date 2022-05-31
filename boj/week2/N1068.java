package boj.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 트리
public class N1068 {
    static ArrayList<ArrayList<Integer>> node = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        init(N);
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp != -1) node.get(temp).add(i);
        }
        int nodeNum = sc.nextInt();
        removeNode(nodeNum);
        System.out.print(getLeafCount());
    }

    static void init(int n) {
        for (int i = 0; i < n; i++) {
            node.add(i, new ArrayList<>());
            node.get(i).add(-1);
        }
    }

    static void removeNode(int n) {
        Queue<Integer> removeList = new LinkedList<>();
        for (int i = node.get(n).size()-1; i >= 0; i--) {
            if(node.get(n).get(i) != -1) removeList.add(node.get(n).get(i));
            node.get(n).remove(i);
        }
        while (!removeList.isEmpty()) {
            int removeNode = removeList.poll();
            for (int i = node.get(removeNode).size()-1; i >=0; i--) {
                if(node.get(removeNode).get(i) != -1) removeList.add(node.get(removeNode).get(i));
                node.get(removeNode).remove(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=node.get(i).size()-1; j >= 0; j--){
                if(node.get(i).get(j) == n) node.get(i).remove(j);
            }
        }
    }

    static int getLeafCount() {
        return (int) node.stream().filter(a -> a.size()==1).count();
    }

    static void printNode() {
        for (int i=0; i<node.size(); i++) {
            System.out.println(i + "의 자식: ");
            for (int j = 0; j < node.get(i).size(); j++) {
                System.out.print(node.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

