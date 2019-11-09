package Graphs.Algorithms;

import Graphs.Models.Edge;
import Graphs.Models.Graph;
import Graphs.Models.Vertex;
import Graphs.Models.Writter;

import java.util.ArrayList;
import java.util.List;

public class ErdosRenyi extends Algorithm {

    private String algorithmType = "ErdosRenyi";

    public ErdosRenyi(int n, int m, boolean directed, boolean named) {
        super();
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }

        System.out.println("[+] Erdos - Renyi");
        ErdosRenyiAlgorithm(m);
        Graph graph = new Graph(vertexes, null, n);
        Writter file0 = new Writter(algorithmType, graph, directed, named);
    }


    public ErdosRenyi(int n, int m, boolean directed, String type, float bound, boolean named) {
        super();
        this.bound = bound;
        for (int i = 0; i < n; i++) {
            Vertex vertex = new Vertex(i, algorithmType);
            vertexes.add(vertex);
        }

        System.out.println("[+] Erdos-Renyi");
        ErdosRenyiAlgorithm(m);
        Graph graph = new Graph(vertexes, new ArrayList(), n);
        Writter file0 = new Writter(algorithmType, graph, directed, named);

        if(type.equals("DIJ")) {
            Dijkstra dij = new Dijkstra();
            List<Vertex> caminoDijk = dij.runDijkstra(graph);
            Graph gDijk = new Graph(caminoDijk, new ArrayList(), n);
            Writter file1 = new Writter(algorithmType + "Dij", gDijk, directed, true);
        }
    }

    private void ErdosRenyiAlgorithm(int m) {

        for (int j = 0; j < m; j++) {
            Edge edge = new Edge(bound);
            int vertex1 = generateNumber(vertexes.size());
            int vertex2 = generateNumber(vertexes.size());

            if (vertexes.get(vertex1).getVertexes().isEmpty()) {
                while (vertex2 == vertex1) {
                    vertex2 = generateNumber(vertexes.size());
                }
                edge.setVertexes(String.valueOf(vertex1), String.valueOf(vertex2));
                vertexes.get(vertex1).addEdge(edge);

            } else if (!vertexes.get(vertex1).getVertexes().isEmpty()) {
                boolean nodeExist = false;
                while (!nodeExist) {
                    for (int i = 0; i < vertexes.get(vertex1).getVertexes().size(); i++) {
                        if (vertexes.get(vertex1).getVertex(i).getVertexB().equals(String.valueOf(vertex2))) {
                            nodeExist = true;
                            break;
                        }
                    }
                    if (nodeExist) {
                        vertex2 = generateNumber(vertexes.size());
                    } else {
                        edge.setVertexes(String.valueOf(vertex1), String.valueOf(vertex2));
                        vertexes.get(vertex1).addEdge(edge);
                    }
                }
            }
        }
    }
}
