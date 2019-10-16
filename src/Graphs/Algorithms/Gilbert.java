package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

;

public class Gilbert extends Algorithm {
    private static double probability;
    private String algorithmType = "Gilbert";

    public Gilbert(int m, double p, boolean directed, int index, String type) {
        super();
        Gilbert.probability = p;

        for (int i = 0; i < m; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Gilbert");
        GilbertAlgorithm();
        Graph graph = new Graph(vertexes, null, m);
        Writter file0 = new Writter(algorithmType, graph, directed);

    }

    public Gilbert(int m, double p, boolean directed) {
        super();
        Gilbert.probability = p;
        for (int i = 0; i < m; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }
        System.out.println("[+] Gilbert");
        GilbertAlgorithm();
        Graph graph = new Graph(vertexes, null, m);
        Writter file = new Writter(algorithmType, graph, directed);
    }

    private void GilbertAlgorithm() {
        for (int j = 0; j < vertexes.size(); j++) {
            for (int i = 0; i < vertexes.size(); i++) {
                double probEdge = randomGenerator.nextDouble();
                if (i != j) {
                    if (probEdge < probability) {
                        Edge edge = new Edge();
                        edge.setVertexes(String.valueOf(j), String.valueOf(i));
                        vertexes.get(j).addEdge(edge);
                    }
                }
            }
        }
    }
}
