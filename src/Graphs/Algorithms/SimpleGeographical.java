package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

public class SimpleGeographical extends Algorithm {

    public SimpleGeographical(int n, double r, boolean directed) {
        super();
        String algorithmType = "Geographic";
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Simple Geographical");
        SimpleGeographicalAlgorithm(r);
        Graph graph = new Graph(vertexes, null, n);
        Writter file = new Writter(algorithmType, graph, directed);
    }

    private void SimpleGeographicalAlgorithm(double r) {
        for (int i = 0; i < vertexes.size(); i++) {
            for (int j = 0; j < vertexes.size(); j++) {
                if (i != j) {
                    if (calculiDistance(vertexes.get(i), vertexes.get(j)) <= r) {
                        Edge edge = new Edge();
                        edge.setVertexes(String.valueOf(i), String.valueOf(j));
                        vertexes.get(i).addEdge(edge);
                    }
                }
            }
        }
    }

    private double calculiDistance(Vertex vertexX, Vertex vertexY) {
        double distance;
        distance = Math.sqrt(Math.pow((vertexY.getCoordX() - vertexX.getCoordX()), 2)
                + Math.pow((vertexY.getCoordY() - vertexX.getCoordY()), 2));
        return distance;
    }
}
