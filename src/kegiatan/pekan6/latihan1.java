package kegiatan.pekan6;

import java.util.*;

public class latihan1 {
    public static void main(String[] args) {
        BreadthFirstSearch b = new BreadthFirstSearch(6);
        DepthFirstSearch d = new DepthFirstSearch(8);

        b.run();
        System.out.println();
        d.run();
    }
}


class BreadthFirstSearch {
    private int node;
    private LinkedList<Integer> list[];
    private Queue<Integer> q;

    BreadthFirstSearch(int values){
        node = values;
        list = new LinkedList[node];

        for (int i = 0; i < values; i++) {
            list[i] = new LinkedList<>();
        }
        q = new LinkedList<Integer>();
    }

    void insert(int x, int y){
        list[x].add(y);
    }

    void BFS(int n){
        boolean nodes[] = new boolean[node];
        int a = 0;

        nodes[n] = true;
        q.add(n);

        while (q.size() != 0) {
            n = q.poll();
            System.out.print(n + " ");

            for (int i = 0; i < list[n].size(); i++) {
                a = list[n].get(i);

                if (!nodes[a]){
                    nodes[a] = true;
                    q.add(a);
                }
            }
        }
    }

    void run() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(6);
        bfs.insert(0, 1);
        bfs.insert(0, 3);
        bfs.insert(0, 4);
        bfs.insert(4, 5);
        bfs.insert(3, 5);
        bfs.insert(1, 2);
        bfs.insert(1, 0);
        bfs.insert(2, 1);
        bfs.insert(4, 1);
        bfs.insert(3, 1);
        bfs.insert(5, 4);
        bfs.insert(5, 3);

        System.out.print("BFS: ");
        bfs.BFS(0);
    }
}


class DepthFirstSearch {
    private LinkedList<Integer> list[];
    private boolean visited[];

    DepthFirstSearch(int values){
        list = new LinkedList[values];
        visited = new boolean[values];

        for (int i = 0; i < values; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    void insert(int src, int dest){
        list[src].add(dest);
    }

    void DFS(int v){
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iterator = list[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();

            if (!visited[n]){
                DFS(n);
            }
        }
    }

    void run() {
        DepthFirstSearch dfs = new DepthFirstSearch(8);
        dfs.insert(0, 1);
        dfs.insert(0, 2);
        dfs.insert(0, 3);
        dfs.insert(1, 3);
        dfs.insert(2, 4);
        dfs.insert(3, 5);
        dfs.insert(3, 6);
        dfs.insert(4, 7);
        dfs.insert(4, 5);
        dfs.insert(5, 2);

        System.out.print("DFS: ");
        dfs.DFS(0);
    }
}