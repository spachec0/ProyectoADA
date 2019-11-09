package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

;import java.util.ArrayList;
import java.util.List;

public class Gilbert extends Algorithm {

    private static double probability;
    private String algorithmType = "Gilbert";

    public Gilbert(int m, double p, boolean directed, String type, float bound, boolean named) {
        super();
        this.bound = bound;

        Gilbert.probability = p;
        for (int i = 0; i < m; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }

        System.out.println("[+] Gilbert");
        GilbertAlgorithm();
        Graph graph = new Graph(vertexes, new ArrayList(), m);
        Writter file0 = new Writter(algorithmType, graph, directed, named);

        if(type.equals("DIJ")){
            Dijkstra dij = new Dijkstra();
            List<Vertex> caminoDijk = dij.runDijkstra(graph);
            Graph gDijk = new Graph(caminoDijk, new ArrayList(), m);
            Writter file1 = new Writter(algorithmType + "Dij", gDijk, directed, true);
        }
    }

    public Gilbert(int m, double p, boolean directed, boolean named) {
        super();
        Gilbert.probability = p;
        for (int i = 0; i < m; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Gilbert");
        GilbertAlgorithm();
        Graph graph = new Graph(vertexes, new ArrayList(), m);

        Writter file = new Writter(algorithmType, graph, directed, named);
    }


    private void GilbertAlgorithm() {
        for (int j = 0; j < vertexes.size(); j++) {
            for (int i = 0; i < vertexes.size(); i++) {
                double probVertex = randomGenerator.nextDouble();
                if (i != j) {
                    if (probVertex < probability) {
                        Edge edge = new Edge(bound);
                        edge.setVertexes(String.valueOf(j), String.valueOf(i));
                        vertexes.get(j).addEdge(edge);
                    }
                }
            }
        }
    }
}
