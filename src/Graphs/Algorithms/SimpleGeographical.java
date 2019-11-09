package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

import java.util.ArrayList;
import java.util.List;

public class SimpleGeographical extends Algorithm {

    private String algorithmType = "Geographic";

    public SimpleGeographical(int n, double r, boolean directed, float bound, String type, boolean named) {
        super();
        this.bound = bound;
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Simple Geographical");
        SimpleGeographicalAlgorithm(r);
        Graph graph = new Graph(vertexes, null, n);
        Writter file0 = new Writter(algorithmType, graph, directed, named);

        if(type.equals("DIJ")) {
            Dijkstra dij = new Dijkstra();
            List<Vertex> caminoDijk = dij.runDijkstra(graph);
            Graph gDijk = new Graph(caminoDijk, new ArrayList(), n);
            Writter file1 = new Writter(algorithmType + "Dij", gDijk, directed, true);
        }
    }

    public SimpleGeographical(int n, double r, boolean directed, boolean named) {
        super();
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Simple Geographical");
        SimpleGeographicalAlgorithm(r);
        Graph graph = new Graph(vertexes, null, n);

        Writter file = new Writter(algorithmType, graph, directed, named);
    }

    private void SimpleGeographicalAlgorithm(double r) {
        for (int i = 0; i < vertexes.size(); i++) {
            for (int j = 0; j < vertexes.size(); j++) {
                if (i != j) {
                    if (calculiDistance(vertexes.get(i), vertexes.get(j)) <= r) {
                        Edge edge = new Edge(bound);
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
