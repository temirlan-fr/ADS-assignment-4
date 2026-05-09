import java.util.*;

public class Main {

    static Map<String, List<String>> adj = new LinkedHashMap<>();
    static Map<String, Boolean> marked = new LinkedHashMap<>();
    static List<String> order = new ArrayList<>();

    public static void main(String[] args) {

        adj.put("A", Arrays.asList("C","B","D"));
        adj.put("B", Arrays.asList("A","C","E","G"));
        adj.put("C", Arrays.asList("A","B","D"));
        adj.put("D", Arrays.asList("C","A"));
        adj.put("E", Arrays.asList("G","F","B"));
        adj.put("F", Arrays.asList("G","E"));
        adj.put("G", Arrays.asList("F","B"));

        for (String v : adj.keySet()) marked.put(v, false);
        System.out.println("=== DFS (Depth First Search) ===");
        System.out.println("Source: A");
        dfs("A");
        System.out.println("DFS order: " + order);

        System.out.println();

        marked.replaceAll((k, v) -> false);
        order.clear();
        System.out.println("=== BFS (Breadth First Search) ===");
        System.out.println("Source: A");
        bfs("A");
        System.out.println("BFS order: " + order);
    }

    static void dfs(String v) {
        marked.put(v, true);
        order.add(v);
        System.out.println("Visit: " + v + " | marked: " + order);
        for (String w : adj.get(v)) {
            if (!marked.get(w)) {
                dfs(w);
            } else {
                System.out.println(w + " is already marked, skip");
            }
        }
    }

    static void bfs(String s) {
        Queue<String> queue = new LinkedList<>();
        marked.put(s, true);
        queue.add(s);
        while (!queue.isEmpty()) {
            String v = queue.poll();
            order.add(v);
            System.out.println("Visit: " + v + " | marked: " + order);
            for (String w : adj.get(v)) {
                if (!marked.get(w)) {
                    marked.put(w, true);
                    queue.add(w);
                    System.out.println("Enqueue: " + w + " | queue: " + queue);
                } else {
                    System.out.println(w + " is already marked, skip");
                }
            }
        }
    }
}