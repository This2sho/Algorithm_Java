package boj.week2;

import java.util.*;

// 트리
public class N1068_version2 {
    static LinkedList<LinkedList<Integer>> tree = new LinkedList<>();
    static int remove, root, cnt = 0, N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            tree.add(i, new LinkedList<>());
        }
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if(temp == -1) root = i;
            else tree.get(temp).push(i);
        }
        remove = sc.nextInt();
        if(remove != root){
            removeNode(remove);
            System.out.print(findLeafNode());
        }else System.out.print(0);
    }

    static void removeNode(int removeNum) {
        // 부모노드에서 찾아서 지우기 -> 1
        for (LinkedList<Integer> integers : tree) {
            for (Integer integer : integers) {
                if(integer == removeNum) integers.remove(integers.indexOf(removeNum));
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(removeNum);

        // remove의 자식들 스택에 집어넣어서 부모 조지기
        LinkedList<Integer> currentNode = tree.get(stack.pop()); // 1
        for (Integer integer : currentNode) {
            stack.push(integer); // 3, 4
        }
        if(!stack.empty()) removeNode(stack.pop());
    }

    // todo. 루트에서부터 노드들을 검색해서 자식노드가 있는지 확인.
    //  있으면 그 노드들도 확인
    //  없으면 리프노드
    static int findLeafNode() {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> rootNode = tree.get(root);
        if(!rootNode.isEmpty()){
            queue.addAll(rootNode);
        }else return 1;

        while(!queue.isEmpty()){
            LinkedList<Integer> currentNode = tree.get(queue.poll());
            if(currentNode.size()==0) cnt++;
            else{
                queue.addAll(currentNode);
            }
        }
        return cnt;
    }

    static void print() {
        for (int i=0; i<tree.size(); i++) {
            System.out.print(i + " : ");
            for (int j : tree.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

