/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projetjava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Hatto
 */
public class UndirectedGraph extends Graph  {

    public UndirectedGraph(List<Integer> vertices, Map<Integer, List<Integer>> edges) {
        super(vertices, edges);
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
