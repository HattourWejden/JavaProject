/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.projetjava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hatto
 */
public class GraphAdapterImpl implements GraphAdapter {
    @Override
    public int[][] fromAdjacencyList(List<List<Integer>> adjacencyList) {
        int n = adjacencyList.size();
        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyList.get(i).contains(j)) {
                    adjacencyMatrix[i][j] = 1;
                } else {
                    adjacencyMatrix[i][j] = 0;
                }
            }
        }

        return adjacencyMatrix;
    }

    @Override
    public List<List<Integer>> fromAdjacencyMatrix(int[][] adjacencyMatrix) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int[] adjacencyMatrix1 : adjacencyMatrix) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < adjacencyMatrix1.length; j++) {
                if (adjacencyMatrix1[j] == 1) {
                    neighbors.add(j);
                }
            }
            adjacencyList.add(neighbors);
        }

        return adjacencyList;
    }

    @Override
    public void addVertexToList(int vertex, List<List<Integer>> adjacencyList) {
        adjacencyList.add(new ArrayList<>());
    }

    @Override
    public void addEdgeToList(int source, int destination, List<List<Integer>> adjacencyList) {
        adjacencyList.get(source).add(destination);
    }
    
}
