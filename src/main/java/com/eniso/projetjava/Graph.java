package com.eniso.projetjava;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class Graph {

    private List<Integer> vertices;
    private Map<Integer, List<Integer>> edges;

    public abstract void AjouterVertices();
    public abstract void AjouterEdges();
    public abstract void EditVertices();
    public abstract void EditEdges();

    public Graph(List<Integer> vertices, Map<Integer, List<Integer>> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Integer> getVertices() {
        return this.vertices;
    }

    public void setVertices(List<Integer> vertices) {
        this.vertices = vertices;
    }

    public Map<Integer, List<Integer>> getEdges() {
        return this.edges;
    }

    public void setEdges(Map<Integer, List<Integer>> edges) {
        this.edges = edges;
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
