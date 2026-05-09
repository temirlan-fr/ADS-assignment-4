//TASK 1

//Visit A — marked: [A]
//first unvisited neighbor: C
//Visit C — marked: [A, C]
//A is already marked, skip
//first unvisited neighbor: B
//Visit B — marked: [A, C, B]
//A is already marked, skip
//C is already marked, skip
//first unvisited neighbor: E
//Visit E — marked: [A, C, B, E]
//first unvisited neighbor: G
//Visit G — marked: [A, C, B, E, G]
//first unvisited neighbor: F
//Visit F — marked: [A, C, B, E, G, F]
//G is already marked, skip
//E is already marked, skip
//no unvisited neighbors, backtrack to G
//Back at G
//B is already marked, skip
//no unvisited neighbors, backtrack to E
//Back at E
//F is already marked, skip
//B is already marked, skip
//no unvisited neighbors, backtrack to B
//Back at B
//G is already marked, skip
//no unvisited neighbors, backtrack to C
//Back at C
//first unvisited neighbor: D
//Visit D — marked: [A, C, B, E, G, F, D]
//C is already marked, skip
//A is already marked, skip
//no unvisited neighbors, search complete
//DFS traversal order: A - C - B - E - G - F - D



//TASK 2

//Visit A — marked: [A]
//enqueue neighbors: C, B, D
//queue: [C, B, D]
//Dequeue C — marked: [A, C]
//A is already marked, skip
//B is already marked, skip
//D is already marked, skip
//queue: [B, D]
//Dequeue B — marked: [A, C, B]
//A is already marked, skip
//C is already marked, skip
//enqueue E
//enqueue G
//queue: [D, E, G]
//Dequeue D — marked: [A, C, B, D]
//C is already marked, skip
//A is already marked, skip
//queue: [E, G]
//Dequeue E — marked: [A, C, B, D, E]
//G is already marked, skip
//enqueue F
//B is already marked, skip
//queue: [G, F]
//Dequeue G — marked: [A, C, B, D, E, G]
//F is already marked, skip
//B is already marked, skip
//queue: [F]
//Dequeue F — marked: [A, C, B, D, E, G, F]
//G is already marked, skip
//E is already marked, skip
//queue: []
//no more vertices, search complete
//BFS traversal order: A - C - B - D - E - G - F




//import java.util.*;
//
//public class Main {
//
//    static Map<String, List<String>> adj = new LinkedHashMap<>();
//    static Map<String, Boolean> marked = new LinkedHashMap<>();
//    static List<String> order = new ArrayList<>();
//
//    public static void main(String[] args) {
//
//        adj.put("A", Arrays.asList("C","B","D"));
//        adj.put("B", Arrays.asList("A","C","E","G"));
//        adj.put("C", Arrays.asList("A","B","D"));
//        adj.put("D", Arrays.asList("C","A"));
//        adj.put("E", Arrays.asList("G","F","B"));
//        adj.put("F", Arrays.asList("G","E"));
//        adj.put("G", Arrays.asList("F","B"));
//
//        for (String v : adj.keySet()) marked.put(v, false);
//        System.out.println("=== DFS (Depth First Search) ===");
//        System.out.println("Source: A");
//        dfs("A");
//        System.out.println("DFS order: " + order);
//
//        System.out.println();
//
//        marked.replaceAll((k, v) -> false);
//        order.clear();
//        System.out.println("=== BFS (Breadth First Search) ===");
//        System.out.println("Source: A");
//        bfs("A");
//        System.out.println("BFS order: " + order);
//    }
//
//    static void dfs(String v) {
//        marked.put(v, true);
//        order.add(v);
//        System.out.println("Visit: " + v + " | marked: " + order);
//        for (String w : adj.get(v)) {
//            if (!marked.get(w)) {
//                dfs(w);
//            } else {
//                System.out.println(w + " is already marked, skip");
//            }
//        }
//    }
//
//    static void bfs(String s) {
//        Queue<String> queue = new LinkedList<>();
//        marked.put(s, true);
//        queue.add(s);
//        while (!queue.isEmpty()) {
//            String v = queue.poll();
//            order.add(v);
//            System.out.println("Visit: " + v + " | marked: " + order);
//            for (String w : adj.get(v)) {
//                if (!marked.get(w)) {
//                    marked.put(w, true);
//                    queue.add(w);
//                    System.out.println("Enqueue: " + w + " | queue: " + queue);
//                } else {
//                    System.out.println(w + " is already marked, skip");
//                }
//            }
//        }
//    }
//}



//TASK 4

//We apply Dijkstra's algorithm starting from Edinburgh. At each step we pick the unvisited vertex with the smallest known distance and update its neighbors.
//Starting from Edinburgh we reach Stirling at 50, Glasgow at 70 and Perth at 100. Then from Stirling we find a shorter path to Perth which is 90. From Perth we finally reach Dundee at 90 + 60 = 150.
//Shortest path: Edinburgh → Stirling → Perth → Dundee
//Total distance: 150




//TASK 5

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[] cities = {"Edinburgh", "Stirling", "Perth", "Glasgow", "Dundee"};

        int INF = 9999;
        int n = 5;

        int[][] dist = {
                {   0,  50, 100,  70, INF },
                {  50,   0,  40,  50, INF },
                { 100,  40,   0, INF,  60 },
                {  70,  50, INF,   0, INF },
                { INF, INF,  60, INF,   0 }
        };

        int[] d       = new int[n];
        int[] prev    = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            d[i]    = INF;
            prev[i] = -1;
        }
        d[0] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || d[v] < d[u])) {
                    u = v;
                }
            }
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (dist[u][v] != INF && d[u] + dist[u][v] < d[v]) {
                    d[v]    = d[u] + dist[u][v];
                    prev[v] = u;
                }
            }
        }

        System.out.println("Shortest path: ");
        int v = 4;
        String path = "";
        while (v != -1) {
            path = cities[v] + " " + path;
            v = prev[v];
        }
        System.out.println(path);
        System.out.println("Total distance: " + d[4]);
    }
}