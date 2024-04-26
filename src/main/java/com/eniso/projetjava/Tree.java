package com.eniso.projetjava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree extends Graph {
    
    private int root;
    private Map<Integer, Integer> parent;
    private Map<Integer, List<Integer>> children;
    private Map<Integer, Integer> depth;

    public Tree(List<Integer> vertices, Map<Integer, List<Integer>> edges, int root,
                Map<Integer, Integer> parent, Map<Integer, List<Integer>> children,
                Map<Integer, Integer> depth) {
        super(vertices, edges);
        this.root = root;
        this.parent = parent;
        this.children = children;
        this.depth = depth;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public Map<Integer, Integer> getParent() {
        return parent;
    }

    public void setParent(Map<Integer, Integer> parent) {
        this.parent = parent;
    }

    public Map<Integer, List<Integer>> getChildren() {
        return children;
    }

    public void setChildren(Map<Integer, List<Integer>> children) {
        this.children = children;
    }

    public Map<Integer, Integer> getDepth() {
        return depth;
    }

    public void setDepth(Map<Integer, Integer> depth) {
        this.depth = depth;
    }

    @Override
    public void AjouterVertices() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void AjouterEdges() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EditVertices() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EditEdges() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public static class BFS {
        
        public void breadthFirstSearch(Graph graph, int startVertex) {
            boolean[] visited = new boolean[graph.getVertices().size()];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (int neighbor : graph.getEdges().get(currentVertex)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
public static class DFS {

    public void depthFirstSearch(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        dfsUtil(graph, startVertex, visited);
    }

    private void dfsUtil(Graph graph, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int neighbor : graph.getEdges().get(currentVertex)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited);
            }
        }
    }
}
public static class Dijkstra {

    public Map<Integer, Integer> dijkstraAlgorithm(WeightedGraph graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (int v : graph.getEdges().get(u)) {
                int weight = graph.getEdges().get(u).get(v);
                if (distances.get(v) > distances.get(u) + weight) {
                    distances.put(v, distances.get(u) + weight);
                    pq.add(new Node(v, distances.get(v)));
                }
            }
        }
        return distances;
    }

    private static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
}
